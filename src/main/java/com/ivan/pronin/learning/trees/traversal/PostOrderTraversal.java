package com.ivan.pronin.learning.trees.traversal;

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
 * Inorder: 1, 3, 2, 5, 7, 6, 4
 *
 * ✅ Use case:
 * For deleting/freeing nodes (children deleted before parent).
 * Useful in expression trees for postfix evaluation.
 */
public class PostOrderTraversal {

    public static class Recursive {

        public static <T> void traverse(TreeNode<T> root) {

        }

    }

    public static class Iterative {

        public static <T> void traverse(TreeNode<T> root) {

        }

    }

}
