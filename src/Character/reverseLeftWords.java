package Character;
/*
    思路：利用StringBuilder
 */
public class reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        res.append(stringBuilder.substring(n)).append(stringBuilder.substring(0,n-1));
        return res.toString();
    }
}
