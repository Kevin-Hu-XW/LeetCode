package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入：");
        int[] nums = new int[0];
        if (scanner.hasNext()){
            int m = scanner.nextInt();
            nums= new int[m];
            for (int i=0;i<m;i++){
                nums[i] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(nums));

        }
        System.out.println(Arrays.toString(nums));
    }
}
