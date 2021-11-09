import java.util.*;

public class Card {
    private static List<String> cards = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Card.compare(s1, s2);
            }
        });
        while (scanner.hasNext()) {
            String[] readLine = scanner.nextLine().split("\\s");
            if(readLine[0].equals("0")) break;
            map.put(readLine[0], readLine[1]);
        }
        if (map.size() == 5 && checkShun(map) && checkHua(map)) {
            System.out.println(1);
            return;
        }
        if(map.size() == 5){
            Map<String, Integer> countMap = generaCountMap(map);
            boolean four = false;
            boolean three = false;
            boolean two = false;
            boolean one = false;
            int oneCount = 0;
            for(Map.Entry<String, Integer> entry : countMap.entrySet()){
                if(entry.getValue().equals(4)){
                    four = true;
                }
                if(entry.getValue().equals(3)){
                    three = true;
                }
                if(entry.getValue().equals(2)){
                    two = true;
                }
                if(entry.getValue().equals(1)){
                    one = true;
                    oneCount++;
                }
            }
            if(four && one){
                System.out.println(2);
                return;
            }
            if (three && two){
                System.out.println(3);
                return;
            }
            if(checkHua(map)){
                System.out.println(4);
                return;
            }
            if(checkShun(map)){
                System.out.println(5);
                return;
            }
            if(three && oneCount == 2){
                System.out.println(6);
                return;
            }
        }
        System.out.println(7);
    }

    public static int compare(String s1, String s2) {
        return cards.indexOf(s1) > cards.indexOf(s2) ? 1 : -1;
    }

    public static Map<String, Integer> generaCountMap(Map<String, String> map) {
        Map<String, Integer> map1 = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map1.put(entry.getKey(), map1.containsKey(entry.getKey()) ? map1.get(entry.getKey()) + 1 : 1);
        }
        return map1;
    }

    public static boolean checkHua(Map<String, String> map) {
        boolean checkHua = true;
        String hua = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (hua.equals("")) {
                hua = entry.getValue();
            } else {
                if (!entry.getValue().equals(hua)) {
                    checkHua = false;
                }
            }
        }
        if (!checkHua) {
            return false;
        }
        return true;
    }

    public static boolean checkShun(Map<String, String> map) {
        String sx = "";
        int nextIndex = 0;
        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            count++;
            sx = entry.getKey();
            if (count == 1) {
                if (entry.getKey().equals("A")) {
                    nextIndex = 0;
                } else {
                    nextIndex = cards.indexOf(sx) + 1;
                }
            }
            if (count > 1) {
                if(entry.getKey().equals("A") && count == map.size()){
                    return true;
                }
                if (!entry.getKey().equals(cards.get(nextIndex))) {
                    return false;
                }
                nextIndex = cards.indexOf(sx) + 1;
            }
        }
        return true;
    }

}
