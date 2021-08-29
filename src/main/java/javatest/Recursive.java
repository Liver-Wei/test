package javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liver
 * @Description
 * @date 2021/5/8 23:44
 */
public class Recursive {
    //candidates=[2,3,5],target=8

    public static List<List<Integer>> combination(int[] candidates, int target, List<List<Integer>> res,
                                                  List<Integer> list, int used) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return res;
        } else {
            for (int i = used; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (target < candidate) continue;
                list.add(candidate);
                combination(candidates, target - candidate, res, list, i);
                list.remove(list.size() - 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(combination(new int[]{2, 3, 5}, 8, new ArrayList<>(),
                new ArrayList<>(), 0));
    }
}
