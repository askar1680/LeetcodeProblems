package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        generate(root, list);
        return list;
    }

    private void generate(TreeNode node, List<Integer> list) {
        if (node == null) return;
        generate(node.left, list);
        generate(node.right, list);
        list.add(node.val);
    }
}
