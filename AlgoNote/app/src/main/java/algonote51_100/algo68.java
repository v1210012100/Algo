package algonote51_100;

/***
 *  二叉搜索树的 中序遍历是有序的 ，
 *  那么 如何依靠这个特点重建呢 。
 *  中序遍历 的 特点 。  如果遍历的 结果 存入一个数组  ，那么左子树部分 和 右子树的部分是被 根节点分开的 。
 *  构建一个二叉树，也就是 不断选中根节点的过程， 。
 *  为了保持平衡 ，选取的根节点就是 中间节点 。
 *
 *  如果使用递归函数 。那么 递归的终止条件 就是  数组的  left >right
 */
public class algo68 {


    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums,0,nums.length-1);
    }

    public TreeNode help(int[] nums , int left ,int right){
        if(left>right) return null;
        int mid = (left + right)/2;
        int mid2 = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums,left,mid-1);
        root.right = help(nums,mid+1,right);
        return root;
    }
}
