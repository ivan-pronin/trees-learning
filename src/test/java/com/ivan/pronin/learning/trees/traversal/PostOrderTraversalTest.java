package com.ivan.pronin.learning.trees.traversal;

import java.util.List;

import com.ivan.pronin.learning.trees.TreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 27.08.2025
 */
class PostOrderTraversalTest {

    @Test
    public void testRecursiveTraversal() {
        var root = TreeFactory.createSampleBST();
        // PostOrder: 1, 3, 2, 5, 7, 6, 4
        PostOrderTraversal.Recursive.traverse(root);
    }

    @Test
    public void testRecursiveTraversalList() {
        var root = TreeFactory.createSampleBST();
        var result = PostOrderTraversal.Recursive.getTraversalList(root);
        Assertions.assertEquals(List.of(1, 3, 2, 5, 7, 6, 4), result);
    }

    /* * Example tree:
     * **         4
     * **       /   \
     * **      2     6
     * **     / \   / \
     * ***** 1   3 5   7
     * PostOrder: 1, 3, 2, 5, 7, 6, 4
     */
    @Test
    public void testIterativeTraversal() {
        var root = TreeFactory.createSampleBST();
        PostOrderTraversal.Iterative.traverse(root);
    }

    @Test
    public void testIterativeTraversalListTwoStacks() {
        var root = TreeFactory.createSampleBST();
        var result = PostOrderTraversal.Iterative.getTraversalListTwoStacks(root);
        Assertions.assertEquals(List.of(1, 3, 2, 5, 7, 6, 4), result);
    }

    @Test
    public void testIterativeTraversalListReverseTrick() {
        var root = TreeFactory.createSampleBST();
        var result = PostOrderTraversal.Iterative.getTraversalListReverseTrick(root);
        Assertions.assertEquals(List.of(1, 3, 2, 5, 7, 6, 4), result);
    }

}