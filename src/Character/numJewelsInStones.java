package Character;

public class numJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        if(jewels==null||stones==null)
            return 0;
        char[] chars = stones.toCharArray();
        int res = 0;
        for(int i=0;i<chars.length;i++){
            if (jewels.contains(String.valueOf(chars[i]))){
                res++;
            }
        }
        return res;
    }
}
