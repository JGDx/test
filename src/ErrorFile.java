import java.util.*;
public class ErrorFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s == null || "".equals(s)) break;
            String[] split = s.split("\\s");
            String key = split[0].substring(split[0].lastIndexOf('\\') + 1) + " " + split[1];
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Map<String,String> map1 = new TreeMap<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return o1.compareTo(o2);
            }
        });
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (int i = 0; i < 8; i ++) {
            String[] split = list.get(i).getKey().split("\\s");
            if(split[0].length() > 16) split[0] = split[0].substring(split[0].length() - 16);
            System.out.println(split[0] + " " + split[1] + " " + list.get(i).getValue());
        }
    }
}
