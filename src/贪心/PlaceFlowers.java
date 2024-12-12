package 贪心;

public class PlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed={1,0,1,0,1,0,1};
        boolean flag =canPlaceFlowers(flowerbed,1);
        System.out.println(flag);
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n>=flowerbed.length){
            return false;
        }
        if (n==0)
            return true;
        int num0=0;
        int num1=0;
        for (int i=0;i<flowerbed.length;i++){
            if (flowerbed[i]==0)
                num0++;
            if (flowerbed[i]==1)
                num1++;
        }
        if (num1==2&&num0>=3){
            if (num0>=2*n+1)
                return true;
        }
        if (num0-num1>=n)
            return true;
        else
            return false;

    }
}
