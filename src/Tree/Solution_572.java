package Tree;

public class Solution_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return find(s, t);
    }

    private boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if ((s != null && t == null) || (s == null && t != null)) return false;
        if (s.val != t.val) return false;
        return equals(s.left, t.left) && equals(s.right, t.right);
    }

    private boolean find(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return equals(s, t) || find(s.left, t) || find(s.right, t);
    }
}
