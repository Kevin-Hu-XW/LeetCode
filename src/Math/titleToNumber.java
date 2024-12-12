package Math;

public class titleToNumber {
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int res = 0;
        for (int i=0;i<chars.length;i++){
            int ascall = chars[i]-64;
            res = res + ascall*(int) Math.pow(26,chars.length-(i+1));  //幂运算
        }
        return res;
    }
    public void moveZeroes(int[] nums) {
        if(nums.length==0)
            throw new RuntimeException("the array is empty!");
        int temp,j;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                while(j<nums.length){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
        }
    }
}
