package exers;

import org.junit.Test;
import sun.security.util.ArrayUtil;

import java.util.*;

/**
 * @author : liulinzhi
 * @date: 2020/07/10/15:51
 * @description:java中的比较器重载 两个接口：
 * 1）java.lang.Comparable，自然排序---compareTo方法实现
 * 2）java.lang.Compatator，定制排序---compare（o1，o2）
 * 任意的比较器有统一的规范：需要两个对象Object o1，Object o2
 * 返回负数表示o1排在o2前
 * 返回正数表示o2排在o1前
 * 返回0时无所谓
 */
public class ComparetorDemo {
//    对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。
//    给定一个整数数组A及它的大小n，请返回最短子数组的长度。
    public int findShortest(int[] A, int n) {
        int begin = n-1,end=0;
        int max=A[0],min=A[n-1];
        for(int i=0;i<n;i++){
            if(max<=A[i]) max=A[i];
            else end=i;

        }
        for(int i=n-1;i>=0;i--){
            if(min>=A[i]) min=A[i];
            else begin=i;
        }
        return begin<end?end-begin+1:0;}


    public static void main(String[] args) {
//        Integer[] arr = {6, 0, 4, 1, 9, 2};
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//
//                return -o1.compareTo(o2);
//            }
//        });
//        for(int i : arr)
//            System.out.print(i + " ");
//
//        PriorityQueue<Integer> heap = new PriorityQueue<>(
//                new Comparator<Integer>() {
//                    @Override
//                    public int compare(Integer o1, Integer o2) {
//                        return -o1.compareTo(o2);
//                    }
//                }
//        );
//        heap.add(1);
//        heap.add(8);
//        heap.add(3);
//        heap.add(2);
//
//        while(!heap.isEmpty())
//            System.out.println(heap.poll());//大根堆了

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();//识别空格和回车
            char[] a = s.toCharArray();
            ArrayList<Character> arr = new ArrayList<>();
            for (int i = 0; i < a.length; i++)
                if (Character.isLetter(a[i]))
                    arr.add(a[i]);
            arr.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return ((Character) Character.toLowerCase(o1)).compareTo(
                            (Character) Character.toLowerCase(o2));
                }
            });
            //对字母单独排好序后插入源数组
            int count = 0;
            for (int i = 0; i < a.length; i++)
                if (Character.isLetter(a[i]))
                    a[i] = arr.get(count++);
            System.out.println(new String(a));
        }
    }

//    @Test
//    public void test1() {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
////            String s = sc.nextLine();//识别空格和回车
////            char[] a = s.toCharArray();
//            ArrayList<Character> arr = new ArrayList<>();
//            for (int i = 0; i < a.length; i++)
//                if (Character.isLetter(a[i]))
//                    arr.add(a[i]);
//            arr.sort(new Comparator<Character>() {
//                @Override
//                public int compare(Character o1, Character o2) {
//                    return ((Character) Character.toLowerCase(o1)).compareTo(
//                            (Character) Character.toLowerCase(o2));
//                }
//            });
//            //对字母单独排好序后插入源数组
//            int count = 0;
//            for (int i = 0; i < a.length; i++)
//                if (Character.isLetter(a[i]))
//                    a[i] = arr.get(count++);
//            System.out.println(a.toString());
//
//        }
//    }
}
