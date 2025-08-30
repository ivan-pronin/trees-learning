package com.ivan.pronin.learning.trees.util;

import com.ivan.pronin.learning.trees.model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}