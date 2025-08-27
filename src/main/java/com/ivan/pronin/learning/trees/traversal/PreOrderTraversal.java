package com.ivan.pronin.learning.trees.traversal;

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

        }

    }

    public static class Iterative {

        public static <T> void traverse(TreeNode<T> root) {

        }

    }

}
