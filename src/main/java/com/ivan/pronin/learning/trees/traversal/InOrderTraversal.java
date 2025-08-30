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
 * Inorder Traversal (Left → Root → Right)
 * Visit left subtree, then current node, then right subtree.
 * For BSTs, inorder traversal always gives values in sorted order.
 *
 * * Example tree:
 * **         4
 * **       /   \
 * **      2     6
 * **     / \   / \
 * ***** 1   3 5   7
 * Inorder: 1, 2, 3, 4, 5, 6, 7
 *
 * ✅ Use case:
 * When you need sorted data from BST.
 * For checking if a tree is a valid BST (sequence must be sorted).
 */
public class InOrderTraversal {

    public static class Recursive {

        public static <T> void traverse(TreeNode<T> root) {
            if (root == null) return;
            traverse(root.getLeft());
            System.out.print(root.getValue() + "->");
            traverse(root.getRight());
        }

        public static <T> List<T> getTraversalList(TreeNode<T> root) {
            return getTraversalList(root, new ArrayList<>());
        }

        private static <T> List<T> getTraversalList(TreeNode<T> root, List<T> result) {
            if (null == root) return List.of();
            getTraversalList(root.getLeft(), result);
            result.add(root.getValue());
            getTraversalList(root.getRight(), result);
            return result;
        }

    }

    public static class Iterative {

        public static <T> void traverse(TreeNode<T> root) {
            if (null == root) return;
            Deque<TreeNode<T>> stack = new ArrayDeque<>();
            var current = root;
            while (!stack.isEmpty() || current != null) {
                while (current != null){
                    stack.push(current);
                    current = current.getLeft();
                }
                current = stack.pop();
                System.out.print(current.getValue() + "->");
                current = current.getRight();
            }
        }

        public static <T> List<T> getTraversalList(TreeNode<T> root) {
            if (null == root) return null;
            List<T> result = new ArrayList<>();
            Deque<TreeNode<T>> stack = new ArrayDeque<>();
            var current = root;
            while (!stack.isEmpty() || current != null) {
                while (current != null){
                    stack.push(current);
                    current = current.getLeft();
                }
                current = stack.pop();
                result.add(current.getValue());
                current = current.getRight();
            }
            return result;
        }

    }

}
