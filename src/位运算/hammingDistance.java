package 位运算;
/*
    异或运算：输入位不同时，为1
    Integer.bitCount(n)返回二进制位中1的个数
 */
public class hammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
