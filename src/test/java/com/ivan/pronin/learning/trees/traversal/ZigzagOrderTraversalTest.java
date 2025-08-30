package com.ivan.pronin.learning.trees.traversal;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.ivan.pronin.learning.trees.TreeFactory.createSampleZigZagTree;

/**
 * @author Ivan Pronin
 * @since 28.08.2025
 * Example tree:
 *
 * ***** 1
 * *** /   \
 * ** 2     3
 * * / \     \
 * 4   5     6
 *
 * Zig-zag levels: [[1], [3, 2], [4, 5, 6]]
 */
class ZigzagOrderTraversalTest {

    // Zig-zag levels: [[1], [3, 2], [4, 5, 6]]
    @Test
    void traverse() {
        var root = createSampleZigZagTree();
        ZigzagOrderTraversal.traverse(root);
    }

    @Test
    void getTraversalList() {
        var root = createSampleZigZagTree();
        var actual = ZigzagOrderTraversal.getTraversalList(root);
        Assertions.assertEquals(List.of(List.of(1), List.of(3,2), List.of(4,5,6)), actual);
    }

}