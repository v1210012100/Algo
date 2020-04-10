package algonote51_100;

import java.util.HashMap;

public class algo63 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        if (inorder.length == 0) return null;

        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    /***
     *  递归函数的跳出 情况  ： 1   检测数组为空   或者是否合法  ，这种情况代表递归函数 只关心自己这次是否合法， 不去关心子函数是否合法
     *  2 在本层 执行时 ，判断是否需要递归 ，但是 对本次递归调用没有做检测 ，这样就需要外部调用递归函数时做检测 。
     *  2 在本层 执行时 ，判断是否需要递归 ，但是 对本次递归调用没有做检测 ，这样就需要外部调用递归函数时做检测 。
     *
     *  这两种情况一种是在 函数 头部跳出 ，一个是在尾部跳出 。
     *
     *  总体来说还是头部 合法检测简单一些
     */
    public TreeNode help(int[] preorder, int x, int y, int[] inorder, int i, int j) {

        int rootValue = preorder[x];
        int middlePos = findRootInOrder(rootValue);
        int leftNum = middlePos - i;
        TreeNode root = new TreeNode(rootValue);


        // 这道题的边界条件还是值得思考的
        //[1,2]
        //[2,1]

        //  前序遍历 preorder = [3,9,20,15,7]
        //中序遍历 inorder = [9,3,15,20,7]
        // 情况一、  子树 不为空 ，则区间 下标 表示 没有问题
        // 情况二、  子树为空 ，  第一颗树的 右子树 为空 。  也就是  middle  ==  j


        if(middlePos == i){
            root.left = null;
        }else{
            root.left = help(preorder, x + 1, x + leftNum, inorder, i, middlePos - 1);
        }

        if(middlePos == i){
            root.right = null;
        }else{
            root.right = help(preorder, x + leftNum + 1, y, inorder, middlePos + 1, j);
        }

        return root;

    }


    /***
     * 头部跳出 ，这种情况当 某个子树 为空时 ，仍然 对 middle 进行了 +1 操作。
     */
    public TreeNode help2(int[] preorder, int x, int y, int[] inorder, int i, int j) {
        if(x>y|| i>j) return null;

        int rootValue = preorder[x];
        int middlePos = findRootInOrder(rootValue);
        int leftNum = middlePos - i;
        TreeNode root = new TreeNode(rootValue);

        root.left = help(preorder, x + 1, x + leftNum, inorder, i, middlePos - 1);

        root.right = help(preorder, x + leftNum + 1, y, inorder, middlePos + 1, j);

        return root;

    }





    public int findRootInOrder(int key) {
        return map.get(key);
    }


}
