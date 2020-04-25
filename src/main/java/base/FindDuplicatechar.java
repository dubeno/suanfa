package base;

import java.util.HashMap;
import java.util.Map;

/**
 * 打印字符串的重复字符
 */
public class FindDuplicatechar {
    public static void main(String args[]){
        printDuplicateWord("Programming");
    }
    public static void printDuplicateWord(String word){
        char [] characters = word.toCharArray();
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for (Character c: characters){
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else   {
                map.put(c,1);
            }
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if (entry.getValue()>1){
                System.out.println(entry.getKey()+"-"+entry.getValue());
            }
        }
    }
}
