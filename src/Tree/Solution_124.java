package Tree;

public class Solution_124 {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findSum(root);
        return result;
    }

    private int findSum(TreeNode node) {
        if (node == null) return 0;

        int left = findSum(node.left);
        int right = findSum(node.right);
        int max = Math.max(node.val + left, node.val + right);
        max = Math.max(max, node.val);

        int maxCase2 = Math.max(max, left + node.val + right);
        result = Math.max(result, maxCase2);

        return max;
    }
}