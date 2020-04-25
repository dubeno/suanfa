package corejava;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import org.apache.commons.io.FileUtils;

public class ZeroCopyClient {

    public static void main(String[] args) throws IOException {

        final File inputFile = new File("D:\\github\\suanfa\\src\\main\\resources\\file.txt");

        FileInputStream fileInputStream = new FileInputStream(inputFile);
        FileChannel fileChannel = fileInputStream.getChannel();
        SocketAddress socketAddress = new InetSocketAddress("localhost", 8083);
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(socketAddress);

        //send input file length and CRC32 checksum to server
        long checksumCRC32 = FileUtils.checksumCRC32(inputFile);
        ByteBuffer request = ByteBuffer.allocate(16);
        request.putLong(inputFile.length());
        request.putLong(checksumCRC32);
        request.flip();
        socketChannel.write(request);

        long totalBytesTransferred = 0;
        while (totalBytesTransferred < inputFile.length()) {
            long bytesTransferred = fileChannel.transferTo(totalBytesTransferred, inputFile.length()-totalBytesTransferred, socketChannel);
            totalBytesTransferred += bytesTransferred;
        }

        //receive output file length and CRC32 checksum from server
        ByteBuffer response = ByteBuffer.allocate(16);
        socketChannel.read(response);
        response.flip();
        long totalBytesReceived = response.getLong();
        long outChecksumCRC32 = response.getLong();

        socketChannel.finishConnect();

        System.out.println("CRC32 equal= " + (checksumCRC32 == outChecksumCRC32));

    }
}