package com.ivan.pronin.learning.trees.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 26.08.2025
 *
 * Level Traversal (Breadth-First)
 * Also called Level-order Traversal.
 * Visit nodes level by level from top to bottom, left to right.
 *
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
 * When you want to see the tree layer by layer (like org charts, shortest path in unweighted graphs).
 * Helpful in designing BFS-based algorithms (finding minimum depth, shortest path, etc.).
 */
public class LevelOrderTraversal {

    public static class Iterative {

        public static <T> void traverse(TreeNode<T> root) {
            if (null == root) return;
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                var current = queue.poll();
                System.out.print(current.getValue() + "->");
                if (current.getLeft() != null) queue.offer(current.getLeft());
                if (current.getRight() != null) queue.offer(current.getRight());
            }
        }

        public static <T> List<T> getTraversalList(TreeNode<T> root) {
            if (null == root) return List.of();
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.offer(root);
            List<T> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                var current = queue.poll();
                result.add(current.getValue());
                if (current.getLeft() != null) queue.offer(current.getLeft());
                if (current.getRight() != null) queue.offer(current.getRight());
            }
            return result;
        }

    }

}
