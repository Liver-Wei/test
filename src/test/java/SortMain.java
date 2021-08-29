import javatest.Sort;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Liver
 * @Description
 * @date 2021/5/9 20:05
 */
public class SortMain {
    private static final int[] list;
    static {
        list=Sort.creatList(10000,1,10000);
        System.out.println("原数组："+Arrays.toString(list));
    }
    long start,end;
    Sort sort = new Sort();

    @Test 
    public void Sort() {
        int[] array = Arrays.copyOf(list,list.length);
        start=System.currentTimeMillis();
        Arrays.sort(array);
        end=System.currentTimeMillis();
        System.out.println("系统排序后的数组："+Arrays.toString(array));
        System.out.println("系统排序运行时间："+(end-start)+"ms");
    }

    @Test
    public void bubbleSort() {
        int[] array = Arrays.copyOf(list,list.length);
        start=System.currentTimeMillis();
        sort.bubbleSort(array);
        end=System.currentTimeMillis();
        System.out.println("冒泡排序后的数组："+Arrays.toString(array));
        System.out.println("冒泡排序运行时间："+(end-start)+"ms");
    }

    @Test
    public void selectSort() {
        int[] array = Arrays.copyOf(list,list.length);
        start=System.currentTimeMillis();
        sort.selectSort(array);
        end=System.currentTimeMillis();
        System.out.println("选择排序后的数组："+Arrays.toString(array));
        System.out.println("选择排序运行时间："+(end-start)+"ms");
    }

    @Test
    public void insertSort() {
        int[] array = Arrays.copyOf(list,list.length);
        start=System.currentTimeMillis();
        sort.insertSort(array);
        end=System.currentTimeMillis();
        System.out.println("插入排序后的数组："+Arrays.toString(array));
        System.out.println("插入排序运行时间："+(end-start)+"ms");
    }
}
