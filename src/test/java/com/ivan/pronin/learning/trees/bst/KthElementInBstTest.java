package com.ivan.pronin.learning.trees.bst;

import com.ivan.pronin.learning.trees.util.TreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 01.09.2025
 */
class KthElementInBstTest {

    @Test
    public void testKthSmallestElement() {
        var root = TreeFactory.createSampleBST4Levels();
        Assertions.assertEquals(0, KthElementInBst.getKthSmallest(1, root));
        Assertions.assertEquals(2, KthElementInBst.getKthSmallest(2, root));
        Assertions.assertEquals(3, KthElementInBst.getKthSmallest(3, root));
        Assertions.assertEquals(4, KthElementInBst.getKthSmallest(4, root));
        Assertions.assertEquals(5, KthElementInBst.getKthSmallest(5, root));
        Assertions.assertEquals(6, KthElementInBst.getKthSmallest(6, root));
        Assertions.assertEquals(7, KthElementInBst.getKthSmallest(7, root));
        Assertions.assertEquals(8, KthElementInBst.getKthSmallest(8, root));
        Assertions.assertEquals(9, KthElementInBst.getKthSmallest(9, root));
    }

    @Test
    public void testKthLargestElement() {
        var root = TreeFactory.createSampleBST4Levels();
        Assertions.assertEquals(9, KthElementInBst.getKthLargest(1, root));
        Assertions.assertEquals(8, KthElementInBst.getKthLargest(2, root));
        Assertions.assertEquals(7, KthElementInBst.getKthLargest(3, root));
        Assertions.assertEquals(6, KthElementInBst.getKthLargest(4, root));
        Assertions.assertEquals(5, KthElementInBst.getKthLargest(5, root));
        Assertions.assertEquals(4, KthElementInBst.getKthLargest(6, root));
        Assertions.assertEquals(3, KthElementInBst.getKthLargest(7, root));
        Assertions.assertEquals(2, KthElementInBst.getKthLargest(8, root));
        Assertions.assertEquals(0, KthElementInBst.getKthLargest(9, root));
    }

}