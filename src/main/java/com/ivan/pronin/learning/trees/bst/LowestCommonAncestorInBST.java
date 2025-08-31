package com.ivan.pronin.learning.trees.bst;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 31.08.2025
 * Implement a method to find the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST).
 * The LCA of two nodes p and q is the deepest node that has both p and q as descendants.
 */
public class LowestCommonAncestorInBST {

    public static TreeNode<Integer> findLCARecursiveCommon(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) return null;
        if (root.getValue().equals(p.getValue()) || root.getValue().equals(q.getValue())) return root;
        var left = findLCARecursiveCommon(root.getLeft(), p, q);
        var right = findLCARecursiveCommon(root.getRight(), p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }

    public static TreeNode<Integer> findLCARecursiveBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) return null;
        if (p.getValue() < root.getValue() && q.getValue() < root.getValue())
            return findLCARecursiveBST(root.getLeft(), p, q);
        if (p.getValue() > root.getValue() && q.getValue() > root.getValue())
            return findLCARecursiveBST(root.getRight(), p, q);
        return root;
    }

    public static TreeNode<Integer> findLCAIterativeBst(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null) return null;
        var current = root;
        while (current != null) {
            if (current.getValue() < p.getValue() && current.getValue() < q.getValue()) {
                current = current.getRight();
            } else if (current.getValue() > p.getValue() && current.getValue() > q.getValue()) {
                current = current.getLeft();
            } else return current;
        }
        return null;
    }

    public static TreeNode<Integer> findLCAIterativeCommon(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        if (root == null || p == null || q == null) return null;
        Map<TreeNode<Integer>, TreeNode<Integer>> parentMap = new HashMap<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        parentMap.put(root, null);
        queue.offer(root);

        // Build parent map
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode<Integer> node = queue.poll();
            if (node.getLeft() != null) {
                parentMap.put(node.getLeft(), node);
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                parentMap.put(node.getRight(), node);
                queue.offer(node.getRight());
            }
        }

        // Collect ancestors of p
        Set<TreeNode<Integer>> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        // Find first common ancestor with q
        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }

}
