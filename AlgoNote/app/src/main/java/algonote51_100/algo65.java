package algonote51_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 前序遍历的 非递归 算法
public class algo65 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;
        while( now !=null||stack.size()>0 ){
            if(now != null){
                list.add(now.val);
                stack.add(now);
                now = now.left;
            }else{
                now = stack.pop().right;
            }

        }
        return list;
    }
}
