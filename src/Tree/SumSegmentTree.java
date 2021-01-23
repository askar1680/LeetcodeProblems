package Tree;

public class SumSegmentTree {

    public static void main(String[] args) {
        int[] array = { 1,3,5,7,9,11 };
        SumSegmentTree segmentTree = new SumSegmentTree(array);
        System.out.println(segmentTree.sumRange(3, 5));
    }

    SegmentTreeNode root = null;

    public SumSegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if (start == end) {
                node.sum = nums[start];
            } else {
                int middle = start + (end - start) / 2;
                node.left = buildTree(nums, start, middle);
                node.right = buildTree(nums, middle + 1, end);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }
    }

    private int sumRange(SegmentTreeNode node, int start, int end) {
        if (start == node.start && end == node.end)
            return node.sum;
        else {
            int middle = node.start + (node.end - node.start) / 2;
            if (end <= middle) {
                return sumRange(node.left, start, end);
            } else if (start >= middle + 1) {
                return sumRange(node.right, start, end);
            } else {
                return sumRange(node.left, start, middle) + sumRange(node.right, middle + 1, end);
            }
        }
    }
}