package algonote51_100;

/***
 *  动态规划能实现的通过递归也是能够实现的;
 *
 *  动态规划的递推公的 优化，， 使用额外的存储空间 节约 递归重复计算的部分。
 *
 *  如何记忆动态规划的题目。
 *  第一 ：递推公式
 *  第二： 时间复杂度和空间复杂度
 *
 *  关于 dp
 *  一、。dp[i] 可能依赖于 一个 dp[i-1] 。 也可能依赖于  多个 之前的 dp
 *  二 、 dp[i]   可能不是最后的 结果
 *  三 、 使用 数组保存的 空间 能否简化 ：  dp[i]  只和 dp[i-1] 相关 。或者可以记录 最大最小值
 */
public class algo88 {

    /***
     * -----------------------------------为什么 从后往前解码 ， 更容易排除 非法的情况 ，如 0 开头的情况 。
     * 从后往前遍历。如果
     * 以22067为例，从后往前遍历。
     * 首先如果为7。很显然是1种7->G
     * 如果为67。很显然还是1种67->FG
     * 如果为067。结果为0。
     * 如果为2067。 结果为numDecodings（20 67）+ numDecodings（2 067）= numDecodings（20 67）->TFG
     * 如果为22067。 结果为numDecodings（2 2067）+ numDecodings（22 067）= numDecodings（2 2067）->BTFG
     *
     * 从中，我们可以看出规律。
     * 如果开始的数为0，结果为0。
     * 如果开始的数加上第二个数小于等于26。结果为 numDecodings（start+1）+ numDecodings（start +2）
     * 如果开始的数加上第二个数大于26。结果为 numDecodings（start +1）
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return digui(s, 0);
    }

    //递归的套路，加一个index控制递归的层次
    private int digui(String s, int start) {
        //递归的第一步，应该是加终止条件，避免死循环。
        if (s.length() == start) {
            return 1;
        }
        //以0位开始的数是不存在的
        if (s.charAt(start) == '0') {
            return 0;
        }
        //递归的递推式应该是如果index的后两位小于等于26，
        // digui(s, start) = digui(s, start+1)+digui(s, start+2)
        // 否则digui(s, start) = digui(s, start+1)
        int ans1 = digui(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ans2 = digui(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

}
