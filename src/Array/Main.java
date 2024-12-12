package Array;


import com.sun.jmx.snmp.SnmpUsmKeyHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    static  Map<String,Boolean> map ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int[] num = new int[str.length()];
        int count= 0,i=0;
        String s="";
        while(i<str.length()){
            if(Character.isDigit(str.charAt(i))){
                s = s + String.valueOf(str.charAt(i));
                int j = i;
                j++;
                if(str.charAt(j)==']'||str.charAt(j)==','){
                    num[count++] = Integer.valueOf(s);
                    s="";
                }
            }
            i++;
        }
        int k=0;
        int[][] nums = new int[count/2][2];
        for (int m=0;m<count/2;m++){
            for (int n=0;n<2;n++){
                if(k<count){
                    nums[m][n] = num[k++];
                }
            }
        }
        for (int m=0;m<count/2;m++){
            for (int n=0;n<2;n++){
                System.out.println(nums[m][n]);
            }
        }
        System.out.println(min(nums,map));

    }
    public static double min(int[][] nums,Map<String,Boolean> map){
        int n = nums.length;
        map = new HashMap<>();
        double ans = Double.MAX_VALUE;
        for (int i=0;i<n;i++){
            map.put(String.valueOf(nums[i][0])+"#"+String.valueOf(nums[i][1]),true);
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                    if (i==j) break;
                    if(i==k||j==k) continue;
                    if (check(nums[i],nums[j],nums[k]))
                        ans = Math.min(ans,findArea(nums[i],nums[j],nums[k]));
                }
            }
        }
       return ans == Double.MAX_VALUE?0:ans;
    }
    private static double findArea(int[] a,int[]b,int[]c){
        double x = Math.sqrt((b[0]-a[0])*(b[0]-a[0])+(b[1]-a[1])*(b[1]-a[1]));
        double y = Math.sqrt((c[0]-a[0])*(c[0]-a[0])+(c[1]-a[1])*(c[1]-a[1]));
        return x*y;
    }
    private static boolean check(int[]a,int[]b,int[]c){
        int dx1 = b[0]-a[0];
        int dy1 = b[1]-a[1];
        int dx2 = c[0]-a[0];
        int dy2 = c[1]-a[1];
        if (dx1*dx2+dy1*dy2!=0) return false;
        int dx3 = b[0]+dx2;
        int dy3 = b[1]+dy2;
        String s1 = String.valueOf(dx3)+"#"+String.valueOf(dy3);
        if (map.containsKey(s1)) return false;
        return true;
    }
}
