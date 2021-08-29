package javatest;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author Liver
 * @Description
 * @date 2020/9/19 18:57
 */
public class time {
    public static void main(String[] args){
//        Date date = new Date();
/*        System.out.println(date.getYear()+1900);
        System.out.println(date.getMonth()+1);
        System.out.println(date.getDay());*/

//        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));

        /*LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印*/

        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);

        int hours = 13;

        int minutes = 20;

        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);

        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);

        // test:

        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)

                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {

            System.err.println("测试失败!");

        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)

                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {

            System.err.println("测试失败!");

        }

    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {

        return bj.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("America/New_York")).toLocalDateTime().plusHours(h).plusMinutes(m);
    }
}
