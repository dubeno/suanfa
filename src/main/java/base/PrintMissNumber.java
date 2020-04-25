package base;

public class PrintMissNumber {
    public static void main(String[] args) {
        int[] arr= {1,1,2,3,5,5,7,9,9,9};
        printMissNumber(arr);
    }
    public static void printMissNumber(int [] arr) {
        int size = arr.length;
        int [] register = new int[arr.length];
        for (int i :arr) {
            register[i] = 1;
        }
        for (int i = 1; i < size; i++) {
            if (register[i]== 0) {
                System.out.println(i);
            }
        }
    }
}
