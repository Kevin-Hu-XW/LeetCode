package Character;
/*
    编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
    思路：双指针进行交换,left,right下标，通过一次遍历即可
 */
public class reverseString_ {
    public static void reverseString(char[] s) {
        int length = s.length;
        char temp;
        for (int left=0,right=length-1;left<=right;left++,right--){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
    public static void main(String[] args) {
        char[] chars = {'a','b','a','c'};
        reverseString(chars);
    }
}
