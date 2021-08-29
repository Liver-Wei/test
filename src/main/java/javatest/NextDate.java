package javatest;


/**
 * @author Liver
 * @Description
 * @date 2021/4/27 21:30
 */
public class NextDate {
    public String getNextDate(int month, int day, int year) {

        if(year<1800||year>2100) return "年份不在范围";
        //为了下面的取余，月份为0~11月,最后在加1即可。day同理
        month--;
        day--;
        //进位
        int carry = 0;
        if (month == 1) {//2月份
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {//闰年判断
                if (day >= 0 && day <= 28) {
                    carry = (day + 2) / 29;
                    day = (day + 2) % 29;
                    month = month + carry;
                } else return "日不在范围";
            } else {
                if (day >= 0 && day <= 27) {
                    carry = (day + 2) / 28;
                    day = (day + 2) % 28;
                    month = month + carry;
                } else return "日不在范围";
            }
        } else if (month == 3 || month == 5 || month == 8 || month == 10) {//有30号的月份
            if (day >= 0 && day <= 29) {
                carry = (day + 2) / 30;
                day = (day + 2) % 30;
                month = month + carry;
            } else return "日不在范围";
        } else if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {//有31号的月份
            if (day >= 0 && day <= 30) {
                carry = (day + 2) / 31;
                day = (day + 2) % 31;
                //处理11(实际上是12月)月份,年份可能会产生进位
                month = (month + carry) % 12;
                //只需判断月份是否跳到了0月份即可
                if (month == 0) year += carry;
            } else return "日不在范围";
        } else return "月份不在范围";

        month++;
        day++;
        return year + "年" + month + "月" + day + "日";
    }
}
