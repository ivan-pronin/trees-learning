package com.ivan.pronin.learning.trees.general;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 01.09.2025
 *
 * Definition:
 * The diameter of a binary tree is the length of the longest path between any two nodes.
 * The path may or may not pass through the root.
 * "Length" = number of edges (sometimes number of nodes;
 * be explicit in interviews — here we’ll use edges, which is the standard LeetCode definition).
 */
public class FindMaxDiameterOfTree {

    private static int maxDiameter = 0;

    public static <T> int getMaxDiameterWidth(TreeNode<T> root) {
        if (null == root || (root.getRight() == null && root.getLeft() == null)) return 0;
        getMaxDepth(root);
        return maxDiameter;
    }

    private static <T> int getMaxDepth(TreeNode<T> root) {
        if (root == null ) return 0;
        int left = getMaxDepth(root.getLeft());
        int right = getMaxDepth(root.getRight());
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }

}
