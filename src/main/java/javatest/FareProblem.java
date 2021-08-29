package javatest;

import java.util.Scanner;

public class FareProblem {
    //计算费用。五个参数：年龄,性别,是否已婚,孩子数量,投保金额
    //static静态方法是为不用实例化FareProblem对象,直接调用
    public float calculate(int age, boolean sex, boolean married, byte childNumbers, float money) {
        //计算点数
        int point = 0;
        if (age >= 20 && age <= 39) {
            point += 6;
        } else if (age >= 40 && age <= 59) {
            point += 4;
        } else {
            point += 2;
        }
        point += sex ? 5 : 3;
        point += married ? 3 : 5;

        //强转为int是为了四舍五入,实现原理：浮点数加0.5取整。如3.6+0.5取整为4
        point -= (int) childNumbers <= 6 ? childNumbers * 0.5 + 0.5 : 3;

        //Math.round,四舍五入api,如Math.round(3.6)=4,*1000再除1000.0是保留三位小数。还有很多其他的方法，可以百度
        //return Math.round((point >= 10 ? money * 0.006f : money * 0.001f) * 1000) / 1000.0f;
        return point >= 10 ? money * 0.006f : money * 0.001f;
    }

    public int numDecodings(String s) {
        return helper(s.toCharArray(), s.length(), 0);
    }

    private int helper(char[] chars, int length, int index) {
        //递归的终止条件，找到了一种解码的方法
        if (index >= length)
            return 1;
        //遇到0跳过
        if (chars[index] == '0')
            return 0;
        //截取一个数字只要不是0肯定是符合条件的
        int res = helper(chars, length, index + 1);
        //判断截取两个的时候是否符合条件，如果也符合条件，就截取两个
        if (index < length - 1 && (chars[index] == '1' || chars[index] == '2' && chars[index + 1] <= '6'))
            res += helper(chars, length, index + 2);
        return res;
    }

    private int pr(char[] chars, int length, int index, int[] map) {
        if (index > length - 1)
            return 1;
        if (chars[index] == '0')
            return 0;
        if (map[index] != -1)
            return map[index];
        int result = pr(chars, length, index - 1, map);
        if (index < length - 1 && (chars[index] == 1 || chars[index] == 2 && chars[index + 1] <= '6'))
            result += pr(chars, length, index + 2, map);
        map[index] = result;
        return result;
    }

    public static void main(String[] args) {
        while (true) {
            //扫描输入流（System.in）,nextxxx读取
            Scanner scanner = new Scanner(System.in);
            System.out.print("输入你的年龄：");
            int age = scanner.nextInt();
            if (age<0){
                System.out.println("error!");
                continue;
            }
            System.out.print("输入你的性别：");
            String s = scanner.next();
            if (!s.equals("男")&& !s.equals("女")){
                System.out.println("error!");
                continue;
            }
            boolean sex = "男".equals(s);
            System.out.print("是否已婚：");
            s=scanner.next();
            if (!s.equals("是")&& !s.equals("否")){
                System.out.println("error!");
                continue;
            }
            boolean married = s.equals("是");
            System.out.print("抚养孩子的个数：");
            byte childNumbers = scanner.nextByte();
            if (childNumbers<0){
                System.out.println("error!");
                continue;
            }
            System.out.print("投保额：");
            float money = scanner.nextFloat();
            if (money<0){
                System.out.println("error!");
                continue;
            }
            FareProblem fareProblem = new FareProblem();
            System.out.println("保费为：" + fareProblem.calculate(age, sex, married, childNumbers, money));
        }
//        Scanner scanner = new Scanner(System.in);
//        FareProblem fareProblem = new FareProblem();
//        System.out.println(fareProblem.numDecodings(scanner.nextLine()));

//        scanner.close();
    }
}
