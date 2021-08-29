package javatest;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Liver
 * @Description
 * @date 2021/1/17 19:39
 */
public class Main {

    public static boolean isValid(String s){

        int n = s.length();
        Deque<Character> stack = new LinkedList<>();

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');

        //()}[]
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(pairs.containsKey(ch)){
                if(stack.peek()!= pairs.get(ch)/* ||stack.isEmpty()*/){
//                    System.out.println(stack.peek());
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String str){
        int n = str.length();
        int[] a = new int[26];
        for (int i = 0; i < n; i++) {
            a[str.charAt(i)-'a']++;
        }

        int max =0 ;
        for (int i = 0; i < 26; i++) {
            if (a[i]>=max){
                max = a[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(isValid(str));
        scan.close();
    }
}
