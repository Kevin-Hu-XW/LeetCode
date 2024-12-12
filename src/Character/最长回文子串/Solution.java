package Character.最长回文子串;


import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String str= longestPalindrome(s);
        System.out.println(str);
    }

    public static String longestPalindrome(String s) {
        //用来存放回文字符串
        String[] str=new String[s.toCharArray().length*s.toCharArray().length];
        int l=0;
        if(s.length()==1) {
            return s;
        }
        if(s.length()==2) {
            char[] chars = s.toCharArray();
            if(chars[0]==chars[1]) {
                return s;
            } else {
                /*
                    Character.toString(chars[0])------char to String
                 */
                return Character.toString(chars[0]);
            }
        }
        char[] c = s.toCharArray();
        char[] c1=new char[c.length];

        boolean flag=true;
        for(int i=0;i<c.length;i++) {
            if(i==0){
                c1[i]=c[i];
            }
            else {
                //判断是否有重复字符串
                for(int j=0;j<i;j++)
                {
                    if(c1[j]==c[i]){
                        c1[i]=c[i];
                        /*
                            把c1中重复的字符串，以及重复字符串之间的字符串复制到c2中，进行在判断是否为回文字符串
                            t,z为重复字符串的下标，而t~z之间的数组可能为回文字符串，t~z之间的字符串复制到c2再中进行判断
                         */
                        int t=0,z=0;
                        t=j;
                        z=i;
                        char[] c2=new char[z-t+1];
                        int h=0;
                        while (h<c2.length&&t<=z){
                            c2[h]=c1[t];
                            h++;
                            t++;
                        }
                        //字符数组转字符串
                        /*
                            如果有重复的字符串，在判断是否为回文字符串
                         */
                        if(c2.length%2==0){
                            //长度为偶数，只需判断前一半和后一般是否相等
                            int g=0,k=c2.length-1;
                            while(g<=c2.length/2-1&&k>=c2.length/2){
                                    if(c2[g]!=c2[k]){
                                    break;
                                }
                                g++;
                                k--;
                            }
                            //说明是正常退出while循环，字符数组中的字符是回文
                            if(g>c2.length/2-1){
                                str[l]=String.valueOf(c2);
                                l++;
                            }
                        }
                        else
                            {
                                //长度为奇数，只需判断以中位数为界限的前一半和后一般是否相等
                                double index=c2.length/2;
                                index =Math.floor(index);
                                int Index=(int)index;
                                int g=0,k=c2.length-1;
                                while(g<Index&&k>Index){
                                    if(c2[g]!=c2[k]){
                                        break;
                                    }
                                    g++;
                                    k--;
                                }
                                //说明是正常退出while循环，字符数组中的字符是回文
                                if(g>=Index) {
                                    str[l]=String.valueOf(c2);
                                    l++;
                                }
                            }
                    }
                }
                c1[i]=c[i];
            }
        }
        for(int i=0;i<str.length;i++){
            if(str[i]!=null){
                flag=false;
                break;
            }
        }
        if(flag==true){
            return Character.toString(s.toCharArray()[0]);
        }
        int max=0;
        int index=0;
        for(int i=0;i<str.length;i++){
            if(str[i]!=null&&str[i].toCharArray().length>max){
                max=str[i].toCharArray().length;
                index=i;
            }
        }
        return str[index];
    }
}
