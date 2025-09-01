package com.ivan.pronin.learning.trees.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    // Stable level-order serialization with '#' for nulls, trailing nulls trimmed
    public static String serialize(TreeNode<Integer> root) {
        if (root == null) return "";
        List<String> out = new ArrayList<>();
        Deque<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> n = q.poll();
            if (n == null) {
                out.add("#");
            } else {
                out.add(String.valueOf(n.getValue()));
                q.add(n.getLeft());
                q.add(n.getRight());
            }
        }
        int k = out.size() - 1;
        while (k >= 0 && out.get(k).equals("#")) k--;
        return String.join(",", out.subList(0, k + 1));
    }

    // Convert a forest of nodes to a sorted list of serialized strings (order-insensitive compare)
    public static List<String> serializeForest(List<TreeNode<Integer>> forest) {
        List<String> s = new ArrayList<>();
        for (TreeNode<Integer> r : forest) s.add(serialize(r));
        Collections.sort(s);
        return s;
    }

}
