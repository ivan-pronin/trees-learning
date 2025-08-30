package com.ivan.pronin.learning.trees.traversal;

import java.util.List;

import com.ivan.pronin.learning.trees.util.TreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 28.08.2025
 */
class LevelOrderTraversalTest {

    // 4, 2, 6, 1, 3, 5, 7
    @Test
    public void testIterativeTraversal() {
        var root = TreeFactory.createSampleBST();
        LevelOrderTraversal.Iterative.traverse(root);
    }

    @Test
    public void testIterativeTraversalList() {
        var root = TreeFactory.createSampleBST();
        var result = LevelOrderTraversal.Iterative.getTraversalList(root);
        Assertions.assertEquals(List.of(4, 2, 6, 1, 3, 5, 7), result);
    }

}