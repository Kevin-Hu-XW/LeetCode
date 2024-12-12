package HashMap;

import java.util.HashMap;

public class HashMapCode {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("zuo", "31");
        System.out.println(map.containsKey("zuo"));
        System.out.println(map.containsValue("31"));
        System.out.println("===========================");
        System.out.println(map.get("zuo"));
        System.out.println(map.get("chenyun"));
        System.out.println("===========================");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("===========================");
        System.out.println(map.remove("zuo"));
        System.out.println(map.containsKey("zuo"));
        System.out.println(map.get("zuo"));
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println("===========================");
    }
}
