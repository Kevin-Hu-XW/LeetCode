package Math;
import java.util.HashSet;
import java.util.Set;

public class isHappy {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n!=1&&!set.contains(n)){
            set.add(n);
            n = getNext(n);

        }
        return n==1;
    }
    public int getNext(int n){
        int res = 0;
        while (n!=0){
            res = res+(n%10)*(n%10);
            n = n/10;
        }
        return res;
    }
}
