/**
 * @author xzh
 * @version 1.0
 * @date 2021/9/21 23:51
 * @email Zonghao.Xu@lianwei.com.cn
 */
import java.util.*;
public class LuDeng {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            long[] left = new long[n];
            long[] right = new long[n];
            for(int i = 0; i < n; i++){
                long num = scanner.nextLong();
                if(num < 100){
                    if(left[i] < num){
                        left[i] = num;
                    }
                    if(right[i] < num){
                        right[i] = num;
                    }
                }else{
                    int j;
                    for(j = 0; j < num / 100; j++){
                        if(i + j < n){
                            right[i + j] = 100;
                        }
                        if( i - j >= 0){
                            left[i - j] = 100;
                        }
                    }
                    long y = num % 100;
                    if(i + j < n && right[i + j] < y){
                        right[i + j] = y;
                    }
                    if( i - j >= 0 && left[i - j] < y){
                        left[i - j] = y;
                    }
                }
            }
            long sum = 0;
            for(int i = 0; i < n - 1; i++){
                long s = 100 - right[i] - left[i + 1];
                if(s > 0){
                    sum += s;
                }
            }
            System.out.println(sum);
        }
    }
}
