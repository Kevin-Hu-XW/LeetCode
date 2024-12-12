package Character;
/*
    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    String newstr = s.replace(oldstr,"%20");
 */
public class replaceSpace {

    public String replaceSpace(String s) {
        if(s.length()==0)
            return null;
        String oldstr = " ";
        String newstr = s.replace(oldstr,"%20");
        return newstr;
    }
}
