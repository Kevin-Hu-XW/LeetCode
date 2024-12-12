package 递归;
/*
    母牛每年生出一只母牛，新生出的母牛3年后也能生出一只母牛，假设母牛不会死，请问N年后，母牛的数量
 */
public class Cow {
    public int CowNumbers(int n) {
        if (n<1)
            return 0;
        if (n==1||n==2||n==3)
            return n;
        return CowNumbers(n-1)+CowNumbers(n-3);
    }
}
