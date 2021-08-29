package javatest;

import java.util.Scanner;

/**
 * @author Liver
 * @Description
 * @date 2021/4/27 13:36
 */
public class PhoneNumbers {

    public String isValidate(String phone) {


        //判断字符窜是否由数字组成
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "电话号码只能由数字组成！";
            }
        }

        String pre;
        if (phone.length() == 7) {
            pre = phone.substring(0, 3);
        } else if (phone.length() == 10) {
            pre = phone.substring(3, 7);
        } else return "电话号码格式错误！";

        //前缀要求非0或1
        for (int i = 0; i < pre.length(); i++) {
            if (pre.charAt(i) == '0' || pre.charAt(i) == '1') {
                return "前缀码不能有0或1！";
            }
        }

        return "电话号码格式正确！";
    }

    public static void main(String[] args) {
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(phoneNumbers.isValidate(scanner.nextLine()));
        }
    }
}
