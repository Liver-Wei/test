package javatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Liver
 * @Description
 * @date 2021/4/19 23:28
 */
public class Test {
    public int removeElement(int[] num, int val) {
//        int p = 0;
//        for (int i = 0; i < num.length; i++) {
//            if (num[i]!=val){
//                num[p++]=num[i];
//            }
//        }
//        return p;


        int left = 0;
        int right = num.length;

        while (left < right) {
            if (num[left] == val) {
                num[left] = num[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

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

    public static List<List<Integer>> triangleYH2(int num) {//动态二维数组
        List<List<Integer>> result = new ArrayList<>();
        int[][] list = new int[num][];
        for (int i = 0; i < num; i++) {
            list[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list[i][j] = 1;
//                    result.add(new ArrayList<>(Collections.singletonList(1)));
                } else {
                    list[i][j] = list[i - 1][j - 1] + list[i - 1][j];
//                    result.add(new ArrayList<>(Collections.singletonList(list[i-1][j-1]+list[i-1][j])));
                }
            }
        }

        for (int i = 0; i < num; i++) {
            result.add(Arrays.stream(list[i]).boxed().collect(Collectors.toList()));
        }
        return result;
    }


    public int me(char[] chars,int length,int index){
        if (index>=length)
            return 1;
        if (chars[index]==0)
            return 0;
        int result=me(chars,length,index+1);

        return 0;
    }

    public static void main(String[] args) {
        List<List<Integer>> yh = triangleYH2(10);
        for (List<Integer> list : yh) {
            System.out.println(list);
        }
        for (int i = 0; i < yh.size(); i++) {
            int number = 1;
            System.out.format("%" + (yh.size() - i) * 2 + "s", "");
            for (int j = 0; j < yh.get(i).size(); j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);

            }
            System.out.println();
        }

        System.out.println(yh);
    }
}
