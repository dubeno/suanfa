package base;

public class StringisPalindromString {
    public static void main(String[] args) {
        System.out.println(isPalindrom("abaa"));
    }
    public static boolean isPalindrom(String str){
        if(null == str){
            return false;
        }
        if("".equals(str)){
            return  false;
        }
        if(str.equals(reverse(str))){
            return true;
        }
        return false;
    }
    public static String reverse(String str){
        if(null==str){
            return null;
        }
        if("".equals(str)){
            return "";
        }
        return str.charAt(str.length()-1)+reverse(str.substring(0,str.length()-1));
    }
}
