package HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;
import java.util.stream.Collectors;

public class TowArrayIntersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null)
            return new int[0];
        //去除两个数组中重复的元素
        Set<Integer> set1 = new HashSet<>();
        for (int i:nums1)
            set1.add(i);
        Set<Integer> set2 = new HashSet<>();
        for (int i:nums2)
            set2.add(i);

        List<Integer> list = new ArrayList<Integer>();
        for (int i:set1){
            if (set2.contains(i)){
                list.add(i);
            }
        }
        int[] num=new int[list.size()];
        int Count=0;
        for (int i:list)
            num[Count++]=i;
        return num;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,2,5,5};


    }
}
