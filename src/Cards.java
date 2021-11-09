import java.util.*;
public class Cards{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> all = new ArrayList<>(Arrays.asList("3","4","5","6","7","8","9","10","J","Q","K","A","2","joker","JOKER"));
        while(scanner.hasNext()){
            String readLine = scanner.nextLine();
            String[] cards = readLine.split("-");
            String[] left = cards[0].split(" ");
            String[] right = cards[1].split(" ");
            if(checkJokers(left)){
                print(left);
                continue;
            }
             if(checkJokers(right)){
                print(right);
                 continue;
            }
            if(left.length == right.length){
                compare(left,right,all);
            }else{
                if(left.length == 4){
                    print(left);
                }else if (right.length == 4){
                    print(right);
                }else{
                    System.out.println("ERROR");
                }
            }
        }
    }
    public static void compare(String[] left, String[] right, List<String> all){
        if(all.indexOf(left[0]) >= all.indexOf(right[0])){
            print(left);
        }else{
            print(right);
        }
    }
    public static void print(String[] strs){
        System.out.println(String.join(" ", strs));
    }
    public static boolean checkJokers(String[] cards){
        int jokerSize = 0;
        for(String str: cards){
            if(str.contains("joker") || str.contains("JOKER")) jokerSize++;
        }
        if(jokerSize >= 2){
            return true;
        }
        return false;
    }
}
