package com.ivan.pronin.learning.trees.util;

import com.ivan.pronin.learning.trees.model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Ivan Pronin
 * @since 30.08.2025
 */
class TreesTest {

    @Test
    void testEqualsWithNull() {
        Assertions.assertTrue(Trees.equals(null, null));
        assertFalse(Trees.equals(null, new TreeNode<>(1, null, null)));
        assertFalse(Trees.equals(new TreeNode<>(1, null, null), null));
    }

    @Test
    void testEqualsWithBothNonNull() {
        var root1 = TreeFactory.createSampleBST();
        var root2 = TreeFactory.createSampleBST();
        Assertions.assertTrue(Trees.equals(root1, root2));
    }

    @Test
    void testNotEqualsWithBothNonNull() {
        var root1 = TreeFactory.createSampleBST();
        var root2 = TreeFactory.createSampleZigZagTree();
        assertFalse(Trees.equals(root1, root2));
    }

    @Test
    void testEqualsWithSingleNode() {
        var root1 = new TreeNode<>(1, null, null);
        var root2 = new TreeNode<>(1, null, null);
        Assertions.assertTrue(Trees.equals(root1, root2));
    }

    @Test
    void testNotEqualsWithSingleNodeByValue() {
        var root1 = new TreeNode<>(1, null, null);
        var root2 = new TreeNode<>(2, null, null);
        assertFalse(Trees.equals(root1, root2));
    }

    @Test
    void testNotEqualsWithDoubleNode() {
        var left = new TreeNode<>(2, null, null);
        var root1 = new TreeNode<>(1, left, null);
        var root2 = new TreeNode<>(2, null, null);
        assertFalse(Trees.equals(root1, root2));
    }

    @Test
    void testGetSize() {
        assertEquals(0, Trees.getSize(null));
        assertEquals(1, Trees.getSize(new TreeNode<>(2, null, null)));
        assertEquals(5, Trees.getSize(TreeFactory.createNonBstTree()));
        assertEquals(6, Trees.getSize(TreeFactory.createSampleZigZagTree()));
        assertEquals(7, Trees.getSize(TreeFactory.createSampleBST()));
        assertEquals(9, Trees.getSize(TreeFactory.createSampleBST4Levels()));
    }

    @Test
    void testGetBalancedHeight() {
        assertEquals(0, Trees.getBalancedHeight(null));
        assertEquals(1, Trees.getBalancedHeight(new TreeNode<>(2, null, null)));
        assertEquals(3, Trees.getBalancedHeight(TreeFactory.createNonBstTree()));
        assertEquals(4, Trees.getBalancedHeight(TreeFactory.createSampleBST4Levels()));
    }

    @Test
    void testGetBalancedHeightForUnbalancedTree() {
        var node3 = new TreeNode<>(3, null, null);
        var node2 = new TreeNode<>(2, node3, null);
        var node1 = new TreeNode<>(1, node2, null);
        assertEquals(-1, Trees.getBalancedHeight(node1));
    }

    @Test
    void testIsBalanced() {
        var node3 = new TreeNode<>(3, null, null);
        var node2 = new TreeNode<>(2, node3, null);
        var node1 = new TreeNode<>(1, node2, null);
        assertFalse(Trees.isBalanced(node1));
    }

    @Test
    void testGetMaxHeight() {
        assertEquals(0, Trees.getMaxHeight(null));
        assertEquals(1, Trees.getMaxHeight(new TreeNode<>(2, null, null)));
        assertEquals(3, Trees.getMaxHeight(TreeFactory.createNonBstTree()));
        assertEquals(4, Trees.getMaxHeight(TreeFactory.createSampleBST4Levels()));

        var node3 = new TreeNode<>(3, null, null);
        var node2 = new TreeNode<>(2, node3, null);
        var node1 = new TreeNode<>(1, node2, null);
        assertEquals(3, Trees.getMaxHeight(node1));
    }

}