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
            traverse(root.left());
            traverse(root.right());
            System.out.print(root.value() + "->");
        }

        public static <T> List<T> getTraversalList(TreeNode<T> root) {
            return getTraversalList(root, new ArrayList<>());
        }

        private static <T> List<T> getTraversalList(TreeNode<T> root, List<T> result) {
            if (null == root) return List.of();
            getTraversalList(root.left(), result);
            getTraversalList(root.right(), result);
            result.add(root.value());
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
                if (current.left() != null) stack1.push(current.left());
                if (current.right() != null) stack1.push(current.right());
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value() + "->");
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
                if (current.left() != null) stack1.push(current.left());
                if (current.right() != null) stack1.push(current.right());
            }
            List<T> result = new ArrayList<>();
            while (!stack2.isEmpty()) {
                result.add(stack2.pop().value());
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
                result.addFirst(node.value()); // reverse order
                if (node.left() != null) stack.push(node.left());
                if (node.right() != null) stack.push(node.right());
            }
            return result;
        }

    }

}
