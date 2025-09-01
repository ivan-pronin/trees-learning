package com.ivan.pronin.learning.trees.util;

import com.ivan.pronin.learning.trees.model.TreeNode;
import lombok.experimental.UtilityClass;

/**
 * @author Ivan Pronin
 * @since 30.08.2025
 */
@UtilityClass
public class Trees {

    public static <T> boolean equals(TreeNode<T> first, TreeNode<T> second) {
        if (first == second) return true;
        if (first == null || second == null) return false;
        return first.getValue() == second.getValue() && equals(first.getLeft(), second.getLeft()) && equals(first.getRight(), second.getRight());
    }

    public static <T> int getSize(TreeNode<T> root) {
        if (root == null) return 0;
        return 1 + getSize(root.getLeft()) + getSize(root.getRight());
    }

    public static <T> boolean isBalanced(TreeNode<T> root) {
        return getBalancedHeight(root) != -1;
    }

    /*
     * returns height of a balanced tree or -1 if not balanced
     */
    public static <T> int getBalancedHeight(TreeNode<T> root) {
        if (root == null) return 0;
        var leftHeight = getBalancedHeight(root.getLeft()) + 1;
        var rightHeight = getBalancedHeight(root.getRight()) + 1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight);
    }

    public static <T> int getMaxHeight(TreeNode<T> root) {
        if (root == null) return 0;
        var leftHeight = getBalancedHeight(root.getLeft()) + 1;
        var rightHeight = getBalancedHeight(root.getRight()) + 1;
        return Math.max(leftHeight, rightHeight);
    }

}
