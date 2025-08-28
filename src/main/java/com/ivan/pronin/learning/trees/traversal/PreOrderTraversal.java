package com.ivan.pronin.learning.trees.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 26.08.2025
 *
 * Preorder Traversal (Root → Left → Right)
 * Visit root first, then left subtree, then right subtree.
 *
 * * Example tree:
 * **         4
 * **       /   \
 * **      2     6
 * **     / \   / \
 * ***** 1   3 5   7
 * Preorder: 4, 2, 1, 3, 6, 5, 7
 *
 * ✅ Use case:
 * For creating a copy/serialization of the tree (since root is seen first).
 * Helpful in expression trees (root operator processed before operands).
 */
public class PreOrderTraversal {

    public static class Recursive {

        public static <T> void traverse(TreeNode<T> root) {
            if (root == null) return;
            System.out.print(root.value() + "->");
            traverse(root.left());
            traverse(root.right());
        }

        public static <T> List<T> getTraversalList(TreeNode<T> root) {
            return getTraversalList(root, new ArrayList<>());
        }

        private static <T> List<T> getTraversalList(TreeNode<T> root, List<T> result) {
            if (root == null) return List.of();
            result.add(root.value());
            getTraversalList(root.left(), result);
            getTraversalList(root.right(), result);
            return result;
        }

    }

    public static class Iterative {

        public static <T> void traverse(TreeNode<T> root) {
            if (root == null) return;
            Deque<TreeNode<T>> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                var current = stack.pop();
                System.out.print(current.value() + "->");
                if (current.right() != null) stack.push(current.right());
                if (current.left() != null) stack.push(current.left());
            }
        }

        public static <T> List<T> getTraversalList(TreeNode<T> root) {
            if (root == null) return List.of();
            List<T> result = new ArrayList<>();
            Deque<TreeNode<T>> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                var current = stack.pop();
                result.add(current.value());
                if (current.right() != null) stack.push(current.right());
                if (current.left() != null) stack.push(current.left());
            }
            return result;
        }

    }

}
