package javatest;

import java.util.Arrays;

/**
 * @author Liver
 * @Description
 * @date 2021/4/28 11:45
 */
public class ZhaoLing {

    //直接递归穷举，好像超时了（子问题重复太多）
    public static int res = Integer.MAX_VALUE;

    public void solution1(int[] money, int pay, int count) {
//        if (pay < 0) {
//            return;
//        }
        if (pay == 0) {
            res = Math.min(res, count);
        }

        for (int value : money) {
            if (pay < 0) continue;
            solution1(money, pay - value, count + 1);
        }
    }

    public int solu(int[] money, int pay) {
        if (pay == 0) {
            return 0;
        }
//        if (pay<0){
//            return -1;
//        }
        int min = Integer.MAX_VALUE;
        for (int value : money) {
            if (pay < 0) continue;
            int res = solu(money, pay - value);
            if (res < min){
                min = res+1;
            }
//           if (res>=0)min = Math.min(min,res+1);
        }
        return min;
    }

    //递归穷举,但记录子问题的答案避免重复计算子问题,降低时间复杂度(自上而下)
    private int solution2(int[] money, int pay, int[] count) {
        if (pay < 0) {//没有找到问题的解
            return -1;
        }
        if (pay == 0) {//找到一个解
            return 0;
        }

        if (count[pay - 1] != 0) {//查找与当前节点对应的记录
            return count[pay - 1];
        }

        int min = Integer.MAX_VALUE;//初始化最小值，使其成为最大值
        for (int value : money) {
            //向父节点返回最短路径
            int res = solution2(money, pay - value, count);
            //子节点相互比较选择最短路径
//            if (res >= 0) {
//                min = Math.min(res + 1, min);
//            }
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        //记录答案
        count[pay - 1] = min ;
        return min == Integer.MAX_VALUE ? -1 : min;//所有的组合没有解的时候才会返回-1
    }

    //动态规划dp(自下而上)
    private int solution3(int[] money, int pay) {
        int[] dp = new int[pay + 1];
        Arrays.fill(dp, pay + 1);
        dp[0] = 0;
        for (int i = 1; i <= pay; i++) {
            for (int value : money) {
                if (value <= i)
                    dp[i] = Math.min(dp[i], dp[i - value] + 1);
            }
        }
        return dp[pay] > pay ? -1 : dp[pay];
    }

    private int solution4(int[] mon, int pay) {
        Integer[] money = new Integer[mon.length];
        for (int i = 0; i < mon.length; i++) {
            money[i] = mon[i];
        }


        Arrays.sort(money, (o1, o2) -> o2 - o1);
        int count = 0;
        for (int i : money) {
            while (pay >= i) {
                pay -= i;
                count++;
            }
        }
        if (pay != 0) return -1;
        return count;
    }

    public static void main(String[] args) {
        int[] money = {186, 419, 83, 408};
        int pay = 6249;
//        int[] money = {50,10,5,1};
//        int pay = 70;
        int[] count = new int[pay];
        System.out.println(new ZhaoLing().solution2(money, pay,count));
    }
}


