import java.util.*;
import java.util.stream.Collectors;
public interface Main{
    public void test();

    default void test2(){
        test();
    }

    public static void main(String[] args) {
        List<String> str = Arrays.asList("abb", "abcd", "fegc", "efe", "adfes");
        maxLength(str);
    }

    public static void maxLength(List<String> list){
        System.out.println(list.stream().filter(s -> s.startsWith("a")).max(Comparator.comparingInt(String::length)).orElse(null));;
    }
}
