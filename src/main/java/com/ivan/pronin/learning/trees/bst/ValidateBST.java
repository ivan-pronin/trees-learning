package com.ivan.pronin.learning.trees.bst;

import java.util.Stack;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 30.08.2025
 */
public class ValidateBST {

    public static boolean isValidBstRecursive(TreeNode<Integer> root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBstIterative(TreeNode<Integer> root) {
        if (null == root) return true;
        Stack<TreeNode<Integer>> nodes = new Stack<>();
        TreeNode<Integer> current = root;
        int prev = Integer.MIN_VALUE;
        while(current != null || !nodes.isEmpty()){
            while(current!=null){
                nodes.push(current);
                current = current.getLeft();
            }
            current = nodes.pop();
            if (current.getValue() <= prev) return false;
            prev = current.getValue();
            current = current.getRight();
        }
        return true;
    }

    //        5
    //      /   \
    //     3     7
    //          /
    //         4   <-- invalid: 4 is in the right subtree of 5
    private static boolean check(TreeNode<Integer> node, long lo, long hi) {
        if (node == null) return true;
        if (node.getValue() <= lo || node.getValue() >= hi) return false; // strict
        return check(node.getLeft(),  lo, node.getValue()) &&
            check(node.getRight(), node.getValue(), hi);
    }

}
