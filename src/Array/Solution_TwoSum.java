package Array;
public class Solution_TwoSum {

    public static void main(String[] args) {
        int [] sum={1,5,7,8,10};
        int target=15;
        int[] index = towSum(sum,target);
        System.out.println(index[0]);
        System.out.println(index[1]);
     }
    public static int[] towSum(int[] num,int target){
        int[] m=new int[2];
        for(int j=0;j<num.length-1;j++){
            for(int k=j+1;k<num.length;k++){
                if(num[j]+num[k]==target){
                     m[0]=j;
                     m[1]=k;
                     break;
                }
            }
        }
        return m;
    }
}
