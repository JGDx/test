import java.util.*;

/**
 * @author xzh
 * @version 1.0
 * @date 2021/10/21 19:10
 * @email Zonghao.Xu@lianwei.com.cn
 */
//给你一个整数数组，返回它的某个非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
//
//换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
//
//注意，删除一个元素后，子数组 不能为空。
//示例 1：
//
//输入：arr = [1,-2,0,3]
//输出：4
//解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
//示例 2：
//
//输入：arr = [1,-2,-2,3]
//输出：3
//解释：我们直接选出 [3]，这就是最大和。
//示例 3：
//
//输入：arr = [-1,-1,-1,-1]
//输出：-1
//解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
public class Test3 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, -1, -1};
        int max = arr[0];
        List<Integer> maxArr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                temp.add(arr[j]);
                List<Integer> temp2 = new ArrayList<>(temp);
                if (temp2.size() > 1) {
                    removeMin(temp2);
                }
                int sum = getSum(temp2);
                if (sum > max) {
                    max = sum;
                    maxArr = temp2;
                }
            }
        }
        for (Integer integer : maxArr) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println(max);
    }

    public static List<Integer> removeMin(List<Integer> list) {
        int min = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(min)) {
                min = i;
            }
        }
        list.remove(min);
        return list;
    }


    public static int getSum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }


}
