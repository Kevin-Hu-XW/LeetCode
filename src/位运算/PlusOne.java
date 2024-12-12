package 位运算;

/*
    根据题意加一，没错就是加一这很重要，因为它是只加一的所以有可能的情况就只有两种：
    1.除9之外的数字加一；
    2.数字9。
    加一得十进一位个位数为 00 加法运算如不出现进位就运算结束了且进位只会是一。
    所以只需要判断有没有进位并模拟出它的进位方式，如十位数加 11 个位数置为 00，如此循环直到判断没有再进位就退出循环返回结果。
    然后还有一些特殊情况就是当出现 9999、999999 之类的数字时，循环到最后也需要进位，出现这种情况时需要手动将它进一位。

 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            digits[i]++;
            //判断是否有进位，若为10，则该位赋值为0
            digits[i] = digits[i]%10;
            if (digits[i]!=0)
                return digits;
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        int[] nums={9,9};
        nums = plusOne(nums);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

}
