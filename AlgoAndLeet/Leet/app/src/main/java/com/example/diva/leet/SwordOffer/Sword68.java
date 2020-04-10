package com.example.diva.leet.SwordOffer;

public class Sword68 {
    /***
     * 二叉搜索树的 最近公共祖先
     * 二叉搜索树的特性 ，根节点比 左子树大，比右子树小。
     * 公共祖先这个东西， 就是子节点的交叉点。    这个节点 恰好满足了   大于 等于其中一个 ，又小于等于另外一个 。
     * 恰好的含义，就是从 根节点遍历下来 的第一个。
     *
     * 时间复杂度 O N ，空间复杂度 O N   。   N 代表树的高度     主要看这个二叉搜索树 的形状，平衡的话是 log（节点数）
     *
     * 执行过程 ：
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val&& q.val<root.val){
            // root仍然是 祖先节点
           return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val&& q.val>root.val){
           return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}
