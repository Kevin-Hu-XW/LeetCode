package Math;
/*
    给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数
    求个、十、百上的数
    while (num!=0){
            res = res + num%10;
            num = num/10;
    }
 */
public class addDigits {

    public int addDigits(int num) {
        int res=0;
        while (num!=0){
            res = res + num%10;
            num = num/10;
        }
        if (res>=10)
            res = addDigits(res);
        return res;
    }
}
