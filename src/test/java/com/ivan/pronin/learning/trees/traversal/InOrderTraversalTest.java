package com.ivan.pronin.learning.trees.traversal;

import java.util.List;

import com.ivan.pronin.learning.trees.util.TreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 27.08.2025
 */
class InOrderTraversalTest {

    @Test
    public void testRecursiveTraversal() {
        var root = TreeFactory.createSampleBST();
        InOrderTraversal.Recursive.traverse(root);
    }

    @Test
    public void testRecursiveTraversalList() {
        var root = TreeFactory.createSampleBST();
        var result = InOrderTraversal.Recursive.getTraversalList(root);
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), result);
    }

    @Test
    public void testIterativeTraversal() {
        var root = TreeFactory.createSampleBST();
        InOrderTraversal.Iterative.traverse(root);
    }

    @Test
    public void testIterativeTraversalList() {
        var root = TreeFactory.createSampleBST();
        var result = InOrderTraversal.Iterative.getTraversalList(root);
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), result);
    }

}