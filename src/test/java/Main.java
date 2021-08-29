import javatest.NextDate;
import javatest.Solution;
import javatest.ZhaoLing;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author Liver
 * @Description
 * @date 2021/5/8 19:24
 */
public class Main {
    @Test
    public void letterCombinations() {//排列组合问题
        long start = System.currentTimeMillis();
        System.out.println(new Solution().letterCombinations("23"));
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间："+ (end - start)+ "ms");
    }

    @Test
    public void reverse() {//整数反转
        System.out.println(new Solution().reverse(-12123335));
    }

    @Test
    public void calculate(){//大整数的使用计算2^64-1
        BigInteger integer = new BigInteger("2");
        System.out.println(integer.pow(64).subtract(BigInteger.valueOf(1)));
        System.out.println((1L<<63-1));//计算2^n-1(n=63)64溢出
        System.out.println(Long.MAX_VALUE);
    }

    @Test
    public void nextDate(){
        NextDate nextDate = new NextDate();
        System.out.println(nextDate.getNextDate(2, 29, 2008));
        System.out.println(nextDate.getNextDate(2, 28, 2009));
        System.out.println(nextDate.getNextDate(3, 31, 2009));
        System.out.println(nextDate.getNextDate(4, 30, 2009));

        System.out.println(nextDate.getNextDate(2, 2, 1765));
        System.out.println(nextDate.getNextDate(6, 9, 2222));
        System.out.println(nextDate.getNextDate(0, 3, 2021));
        System.out.println(nextDate.getNextDate(13, 3, 2021));
        System.out.println(nextDate.getNextDate(3, 0, 2021));
        System.out.println(nextDate.getNextDate(2, 30, 2008));
        System.out.println(nextDate.getNextDate(2, 29, 2021));
        System.out.println(nextDate.getNextDate(5, 32, 2021));
        System.out.println(nextDate.getNextDate(4, 31, 2021));
        System.out.println(nextDate.getNextDate(3, 32, 2021));
    }

    @Test
    public void zhaoLing(){
        int[] money = {50,10,5,1};
        int pay = 65;
        ZhaoLing zhaoLing = new ZhaoLing();
        zhaoLing.solution1(money, pay,0);
        System.out.println(ZhaoLing.res);
    }

    @Test
    public void zhao(){
        int[] money = {50,10,5,1};
        int pay = 63;
        ZhaoLing zhaoLing = new ZhaoLing();
        System.out.println(zhaoLing.solu(money, pay));
    }

    @Test
    public void hex() {//十六进制转十进制
        System.out.println(Integer.parseInt("27c00", 16) / 1024 + "KB");
    }
}
