package algonote51_100;

// 回溯
public class algo62 {

    /***
     * 叶子节点的约束条件
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        //  唯一判断的情况就是  root 不为空 ，但是 两个子节点为空 。这样 是防止  ，错把 空节点 当做 叶子节点 。。。。。。。。。。。。
        if(root.left == null && root.right==null){
            return  root.val == sum;
        }else{
            return hasPathSum(root.left,sum-root.val)|| hasPathSum(root.right, sum - root.val);
        }
    }

    /***
     * 这种计算的 问题 在 哪 。 就是把路径上的节点当做根节点了
     * @param root
     * @param sum
     * @return
     */
    public boolean help(TreeNode root, int sum){
        if(root == null ) return sum ==0;
        return help(root.left,sum - root.val)|| help(root.right,sum-root.val);
    }
}
