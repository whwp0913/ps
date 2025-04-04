/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/?envType=daily-question&envId=2025-04-04
 */
public class LowestCommonAncestorofDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = getMaxDepth(root);
        return dfs(root, maxDepth, 0);
    }

    private int getMaxDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
    }

    private TreeNode dfs(TreeNode node, int maxDepth, int depth) {
        if (node == null)
            return null;
        if (depth == maxDepth - 1)
            return node;

        TreeNode left = dfs(node.left, maxDepth, depth + 1);
        TreeNode right = dfs(node.right, maxDepth, depth + 1);

        if (left != null && right != null)
            return node;

        return left != null ? left : right;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

