import java.util.*;

/**
 * @author xzh
 * @version 1.0
 * @date 2021/10/8 19:35
 * @email Zonghao.Xu@lianwei.com.cn
 */
//按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出，不区分大小写
//例：
//输入：abcqweracb
//输出：abcqwer。
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for(int i = 0; i < str.length(); i++){
                set.add(str.charAt(i));
            }
            for(Character c : set){
                System.out.print(c);
            }
        }
    }
}
