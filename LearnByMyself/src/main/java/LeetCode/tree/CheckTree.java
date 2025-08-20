package LeetCode.tree;

import Model.TreeNode;

public class CheckTree {

	public boolean compareTreeNode(TreeNode left, TreeNode right) {
		if (left != null && right == null) {
			return false;
		} else if (left == null && right != null) {
			return false;
		} else if (left == null && right == null) {
			return true;
		} else {
			boolean inside = compareTreeNode(left.getRight(), right.getLeft());
			boolean outside = compareTreeNode(left.getLeft(), right.getRight());
			return inside && outside;
		}
	}
}
