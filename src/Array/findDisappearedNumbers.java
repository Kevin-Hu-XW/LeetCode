package Array;
import java.util.*;

public class findDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer,Integer> mapNums = new HashMap<>();
        HashMap<Integer,Integer> mapRes = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            mapNums.put(nums[i],nums[i]);
            mapRes.put(i+1,i+1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer:mapRes.keySet()){
            if (mapNums.get(integer)==null){
                list.add(integer);
            }
        }
        return list;
    }
}
