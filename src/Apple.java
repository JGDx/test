import java.util.Scanner;
/**
 * @author xzh
 * @version 1.0
 * @date 2021/9/21 20:55
 * @email Zonghao.Xu@lianwei.com.cn
 */
public class Apple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(count(m, n));
        }
        sc.close();
    }

    public static int count(int m, int n) {
        //不可能是负数
        if (m < 0 || n <= 0) {
            return 0;
        }
        // 细分为苹果数为1或盘子数为一的情况返回1
        //一个苹果、一个盘子、没有苹果，就都只有一种情况
        //给出了下限，1种1种的向上累计
        if (m == 1 || n == 1 || m == 0) {
            return 1;
        }
        // 将事件无线细分
        return count(m, n - 1) + count(m - n, n);
//			1.假设有一个盘子为空，则(m,n)问题转化为将m个苹果放在n-1个盘子上，即求得(m,n-1)即可
//			2.假设所有盘子都装有苹果，则每个盘子上至少有一个苹果，即最多剩下m-n个苹果，问题转化为将m-n个苹果放到n个盘子上
//			即求(m-n，n)
//			就转换为了以上两种情况
    }
}
