package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashCode2 {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("zuo", "31");
        map.put("cheng", "32");
        map.put("yun", "33");
        for (String key:map.keySet())
            System.out.print(key+" ");
        System.out.println();
        for (String value:map.values()){
            System.out.print(value+" ");
        }
        System.out.println();
        for (Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        List<String> removekeys = new ArrayList<String>();
        for (String key:map.keySet()) {
            if (key.equals("cheng"))
                removekeys.add(key);
        }
        for (String removekey:removekeys){
            map.remove(removekey);
        }
        for (Map.Entry<String,String> entry:map.entrySet()) {
            System.out.print(entry.getKey()+":"+entry.getValue()+"     ");
        }

    }
}
