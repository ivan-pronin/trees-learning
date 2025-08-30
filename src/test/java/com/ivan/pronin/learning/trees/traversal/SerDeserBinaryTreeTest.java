package com.ivan.pronin.learning.trees.traversal;

import com.ivan.pronin.learning.trees.util.TreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 30.08.2025
 */
class SerDeserBinaryTreeTest {

    @Test
    public void testPreorderSerialization() {
        var root = TreeFactory.createSampleZigZagTree();
        var actual = SerDeserBinaryTree.PreOrder.serialize(root);
        Assertions.assertEquals("1,2,4,#,#,5,#,#,3,#,6,#,#", actual);
    }

    @Test
    public void testPreorderDeserialization() {
        var root = TreeFactory.createSampleZigZagTree();
        var actual = SerDeserBinaryTree.PreOrder.deserialize("1,2,4,#,#,5,#,#,3,#,6,#,#");
        Assertions.assertEquals(root, actual);
    }

    /*
     * Example tree:
     *        1
     *      /   \
     *     2     3
     *    / \     \
     *   4   5     6
     */
    @Test
    public void testBfsSerialization() {
        var root = TreeFactory.createSampleZigZagTree();
        var actual = SerDeserBinaryTree.BfsIterative.serialize(root);
        Assertions.assertEquals("1,2,3,4,5,#,6", actual);
    }

    @Test
    public void testBfsDeserialization() {
        var root = TreeFactory.createSampleZigZagTree();
        var actual = SerDeserBinaryTree.BfsIterative.deserialize("1,2,3,4,5,#,6");
        Assertions.assertEquals(root, actual);
    }

}