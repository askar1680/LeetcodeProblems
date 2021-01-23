package Tree;

public class Solution_1022 {
    int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        fillPaths(root, 0);
        return result;
    }

    private void fillPaths(TreeNode node, int currentNumber) {
        if (node == null) return;
        currentNumber = (currentNumber << 1) + node.val;
        if (node.left == null && node.right == null) {
            result += currentNumber;
        } else {
            fillPaths(node.left, currentNumber);
            fillPaths(node.right, currentNumber);
        }
    }
}
