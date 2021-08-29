package javatest;

import java.util.Scanner;

/**
 * @author Liver
 * @Description
 * @date 2021/4/18 20:21
 */
public class TriangleProblem {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a + b > c && a + c > b && b + c > a) {
                if (a == b && a == c) {
                    System.out.println("等边三角形");
                } else if (a == b || a == c || b == c) {
                    System.out.println("等腰三角形");
                } else {
                    System.out.println("普通三角形的周长为：" + (a + b + c));
                }
            } else {
                System.out.println("无法构成三角形");
            }
        }
    }
}
