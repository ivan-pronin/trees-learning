package com.ivan.pronin.learning.trees.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 26.08.2025
 *
 * Postorder Traversal (Left → Right → Root)
 * Visit left subtree, then right subtree, then root at the end.
 *
 * * Example tree:
 * **         4
 * **       /   \
 * **      2     6
 * **     / \   / \
 * ***** 1   3 5   7
 * PostOrder: 1, 3, 2, 5, 7, 6, 4
 *
 * ✅ Use case:
 * For deleting/freeing nodes (children deleted before parent).
 * Useful in expression trees for postfix evaluation.
 */
public class PostOrderTraversal {

    public static class Recursive {

        public static <T> void traverse(TreeNode<T> root) {
            if (null == root) return;
            traverse(root.getLeft());
            traverse(root.getRight());
            System.out.print(root.getValue() + "->");
        }

        public static <T> List<T> getTraversalList(TreeNode<T> root) {
            return getTraversalList(root, new ArrayList<>());
        }

        private static <T> List<T> getTraversalList(TreeNode<T> root, List<T> result) {
            if (null == root) return List.of();
            getTraversalList(root.getLeft(), result);
            getTraversalList(root.getRight(), result);
            result.add(root.getValue());
            return result;
        }

    }

    public static class Iterative {

        public static <T> void traverse(TreeNode<T> root) {
            if (root == null) return;
            Stack<TreeNode<T>> stack1 = new Stack<>();
            Stack<TreeNode<T>> stack2 = new Stack<>();
            stack1.push(root);

            while (!stack1.isEmpty()) {
                var current = stack1.pop();
                stack2.push(current);
                if (current.getLeft() != null) stack1.push(current.getLeft());
                if (current.getRight() != null) stack1.push(current.getRight());
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().getValue() + "->");
            }
        }

        public static <T> List<T> getTraversalListTwoStacks(TreeNode<T> root) {
            if (root == null) return List.of();
            Stack<TreeNode<T>> stack1 = new Stack<>();
            Stack<TreeNode<T>> stack2 = new Stack<>();
            stack1.push(root);

            while (!stack1.isEmpty()) {
                var current = stack1.pop();
                stack2.push(current);
                if (current.getLeft() != null) stack1.push(current.getLeft());
                if (current.getRight() != null) stack1.push(current.getRight());
            }
            List<T> result = new ArrayList<>();
            while (!stack2.isEmpty()) {
                result.add(stack2.pop().getValue());
            }
            return result;
        }

        public static <T> List<T> getTraversalListReverseTrick(TreeNode<T> root) {
            LinkedList<T> result = new LinkedList<>();
            if (root == null) return result;

            Stack<TreeNode<T>> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode<T> node = stack.pop();
                result.addFirst(node.getValue()); // reverse order
                if (node.getLeft() != null) stack.push(node.getLeft());
                if (node.getRight() != null) stack.push(node.getRight());
            }
            return result;
        }

    }

}
