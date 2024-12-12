package Character;

import java.util.ArrayList;
import java.util.List;

public class myAtoi {
    public static int myAtoi(String s) {
        String str = s.trim();
        if(str.length()==0) return 0;
        boolean flag = true;
        List<Character> list = new ArrayList<>();
        if(str.charAt(0)=='-') flag = false;
        else if (str.charAt(0)=='+') flag = true;
        else if(Character.isDigit(str.charAt(0))) list.add(str.charAt(0));
        else return 0;
        for(int i=1;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                list.add(str.charAt(i));
            }
            else{
                break;
            }
        }
        boolean res = true;
        long conut = 0;
        if(list.size()>0){
            conut = list.get(0)-'0';
            for(int i=1;i<list.size();i++){
                conut = conut*10+list.get(i)-'0';
                if(conut>Integer.MAX_VALUE) {
                    conut = Integer.MAX_VALUE;
                    res = false;
                    break;
                }
            }
        }

        if(flag){
            return (int)conut;
        }
        else {
            if(conut==Integer.MAX_VALUE&&!res)
                return (int)-conut-1;
            return (int)-conut;
        }

    }

    public static void main(String[] args) {
        System.out.println(myAtoi(" "));
        System.out.println(Integer.MAX_VALUE);
    }
}