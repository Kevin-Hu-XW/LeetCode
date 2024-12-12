package Character;


import java.util.*;


public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//
//        String[] nums1 = new String[m];
//        int[] nums2 = new int[n];
//        for (int i=0;i<m;i++){
//            nums1[i] = sc.next();
//        }
//
//        for (int j=0;j<n;j++){
//            nums2[j] = sc.nextInt();
//        }

//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));


//        String line = sc.nextLine();
//        System.out.println("输出");
//        System.out.println(line);
//        String[] str = line.split(" ");
//        System.out.println(Arrays.toString(str));

        System.out.println("输出");

        int m = sc.nextInt();
        String[] strs = new String[m];

        sc.nextLine();   // 很重要，跳到第二行

        for (int i=0;i<m;i++){
            strs[i] = sc.nextLine();
        }
        List<String[]> strList = new ArrayList<>();
        for (int i=0;i<m;i++){
            String[] tmp = strs[i].trim().split(" ");
            strList.add(tmp);
        }
        System.out.println(strList);
        for (int i=0;i<m;i++){

            System.out.println(Arrays.toString(strList.get(i)));
        }
        return ;
    }
}
