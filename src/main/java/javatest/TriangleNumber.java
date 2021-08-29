package javatest;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Liver
 * @Description
 * @date 2021/4/29 15:15
 */
public class TriangleNumber {

    public static List<List<Integer>> triangleYH(int num) {//顺序表
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    list.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    list.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        System.out.println(list);
        System.out.println(list.indexOf(1));
        return ret;
    }

    public static void main(String[] args) {
        triangleYH(10);
    }
}
