package com.ivan.pronin.learning.trees.traversal;

import java.util.List;

import com.ivan.pronin.learning.trees.TreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 27.08.2025
 */
class PreOrderTraversalTest {

    @Test
    public void testRecursiveTraversal() {
        var root = TreeFactory.createSampleTree();
        PreOrderTraversal.Recursive.traverse(root);
    }

    @Test
    public void testRecursiveTraversalList() {
        var root = TreeFactory.createSampleTree();
        var result = PreOrderTraversal.Recursive.getTraversalList(root);
        Assertions.assertEquals(List.of(4, 2, 1, 3, 6, 5, 7), result);
    }

    @Test
    public void testIterativeTraversal() {
        var root = TreeFactory.createSampleTree();
        PreOrderTraversal.Iterative.traverse(root);
    }

    @Test
    public void testIterativeTraversalList() {
        var root = TreeFactory.createSampleTree();
        var result = PreOrderTraversal.Iterative.getTraversalList(root);
        Assertions.assertEquals(List.of(4, 2, 1, 3, 6, 5, 7), result);
    }

}