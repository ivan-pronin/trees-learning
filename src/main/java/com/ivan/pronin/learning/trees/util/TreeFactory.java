package com.ivan.pronin.learning.trees.util;

import com.ivan.pronin.learning.trees.model.TreeNode;
import lombok.experimental.UtilityClass;

/**
 * @author Ivan Pronin
 * @since 26.08.2025
 */
@UtilityClass
public class TreeFactory {

    /*
     * Example tree:
     *         4
     *       /   \
     *      2     6
     *     / \   / \
     *    1   3 5   7
     */
    public static TreeNode<Integer> createSampleBST() {
        var node3 = new TreeNode<>(3, null, null);
        var node1 = new TreeNode<>(1, null, null);
        var node5 = new TreeNode<>(5, null, null);
        var node7 = new TreeNode<>(7, null, null);

        var node2 = new TreeNode<>(2, node1, node3);
        var node6 = new TreeNode<>(6, node5, node7);

        return new TreeNode<>(4, node2, node6);
    }

    /*
     * Example tree:
     *        1
     *      /   \
     *     2     3
     *    / \     \
     *   4   5     6
     */
    public static TreeNode<Integer> createSampleZigZagTree() {
        var node4 = new TreeNode<>(4, null, null);
        var node5 = new TreeNode<>(5, null, null);
        var node6 = new TreeNode<>(6, null, null);

        var node2 = new TreeNode<>(2, node4, node5);
        var node3 = new TreeNode<>(3, null, node6);

        return new TreeNode<>(1, node2, node3);
    }

    /*
     * Example tree:
     *        10
     *      /   \
     *     20     5
     *    /        \
     *   22         8
     */
    public static TreeNode<Integer> createNonBstTree() {
        var node22 = new TreeNode<>(22, null, null);
        var node8 = new TreeNode<>(8, null, null);

        var node20 = new TreeNode<>(20, node22, null);
        var node5 = new TreeNode<>(5, null, node8);

        return new TreeNode<>(10, node20, node5);
    }

    /*
     * Example tree:
     *       6
     *     /   \
     *    2     8
     *   / \   / \
     *  0   4 7   9
     *     / \
     *    3   5
     */
    public static TreeNode<Integer> buildSampleBST4Levels() {
        TreeNode<Integer> root = new TreeNode<>(6);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(8));
        root.getLeft().setLeft(new TreeNode<>(0));
        root.getLeft().setRight(new TreeNode<>(4));
        root.getLeft().getRight().setLeft(new TreeNode<>(3));
        root.getLeft().getRight().setRight(new TreeNode<>(5));
        root.getRight().setLeft(new TreeNode<>(7));
        root.getRight().setRight(new TreeNode<>(9));
        return root;
    }

}
