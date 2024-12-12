package Math;

public class isPowerOfThree {
    public static boolean isPowerOfThree(int n) {
        if(n==0)
            return false;
        if(n==1)
            return true;
        int i = n%3;
        int j = n/3;
        while(i==0){
            if(i==0&&j==1)
                return true;
            n = j;
            i = n%3;
            j = n/3;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        String s =" ";
        s.charAt(0);
    }
}
