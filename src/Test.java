import java.util.*;
public class Test{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a=1,b=0,c=0;
        while(scanner.hasNext()){
            Set<String> set = new HashSet<>();
            Integer[] tmp = new Integer[10];
            String ip = scanner.nextLine();
            String ip2 = scanner.nextLine();
            String[] ips = ip.split("\\.");
            StringBuilder sb = new StringBuilder();
            for(String item : ips){
                sb.append(append(Integer.toBinaryString(Integer.parseInt(item)), 8));
            }
            System.out.println(Integer.parseInt(sb.toString(),2));
            ip2 = append(Integer.toBinaryString(Integer.parseInt(ip2)), 32);
            String[] ips2 = new String[4];
            for(int i = 0; i <= ip2.length() - 8; i = i + 8){
                ips2[i/8] = String.valueOf(Integer.parseInt(ip2.substring(i,i+8), 2));
            }
            System.out.println(String.join(".", ips2));
        }
    }
    public static String append(String str, int num){
        if(str.length() < num){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < num - str.length(); i++){
                sb.append("0");
            }
            return sb.append(str).toString();
        }
        return str;
    }
}
