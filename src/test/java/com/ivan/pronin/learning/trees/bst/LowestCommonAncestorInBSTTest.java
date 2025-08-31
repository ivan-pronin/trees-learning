package com.ivan.pronin.learning.trees.bst;

import org.junit.jupiter.api.Test;

import static com.ivan.pronin.learning.trees.util.TreeFactory.buildSampleBST4Levels;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ivan Pronin
 * @since 31.08.2025
 */
class LowestCommonAncestorInBSTTest {

    @Test
    void testLCARecursiveCommon() {
        var root = buildSampleBST4Levels();
        var p = root.getLeft(); // 2
        var q = root.getRight(); // 8
        assertEquals(root, LowestCommonAncestorInBST.findLCARecursiveCommon(root, p, q));

        p = root.getLeft(); // 2
        q = root.getLeft().getRight(); // 4
        assertEquals(root.getLeft(), LowestCommonAncestorInBST.findLCARecursiveCommon(root, p, q));
    }

    @Test
    void testLCARecursiveBST() {
        var root = buildSampleBST4Levels();
        var p = root.getLeft(); // 2
        var q = root.getRight(); // 8
        assertEquals(root, LowestCommonAncestorInBST.findLCARecursiveBST(root, p, q));

        p = root.getLeft(); // 2
        q = root.getLeft().getRight(); // 4
        assertEquals(root.getLeft(), LowestCommonAncestorInBST.findLCARecursiveBST(root, p, q));
    }

    @Test
    void testLCAIterativeCommon() {
        var root = buildSampleBST4Levels();
        var p = root.getLeft(); // 2
        var q = root.getRight(); // 8
        assertEquals(root, LowestCommonAncestorInBST.findLCAIterativeCommon(root, p, q));

        p = root.getLeft(); // 2
        q = root.getLeft().getRight(); // 4
        assertEquals(root.getLeft(), LowestCommonAncestorInBST.findLCAIterativeCommon(root, p, q));

    }

    @Test
    void testLCAIterativeBST() {
        var root = buildSampleBST4Levels();
        var p = root.getLeft(); // 2
        var q = root.getRight(); // 8
        assertEquals(root, LowestCommonAncestorInBST.findLCAIterativeBst(root, p, q));

        p = root.getLeft(); // 2
        q = root.getLeft().getRight(); // 4
        assertEquals(root.getLeft(), LowestCommonAncestorInBST.findLCAIterativeBst(root, p, q));
    }

}