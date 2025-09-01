package com.ivan.pronin.learning.trees.bst;

import java.util.Arrays;

import com.ivan.pronin.learning.trees.model.TreeNode;
import com.ivan.pronin.learning.trees.traversal.InOrderTraversal;
import com.ivan.pronin.learning.trees.util.Trees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ivan Pronin
 * @since 01.09.2025
 */
class SortedArrayToBstTest {

    private static int[] arr(int... v) {
        return v;
    }

    private void assertBstAndOrder(int[] nums, TreeNode<Integer> root) {
        // inorder must match original sorted sequence
        assertEquals(Arrays.stream(nums).boxed().toList(), InOrderTraversal.Recursive.getTraversalList(root));
        // tree should be height-balanced
        assertTrue(Trees.isBalanced(root));
    }

    private void assertBoth(int[] nums) {
        var r1 = SortedArrayToBst.sortedArrayToBST(nums);
        assertBstAndOrder(nums, r1);
    }

    @Test
    void empty() {
        assertNull(SortedArrayToBst.sortedArrayToBST(new int[]{}));
        assertNull(SortedArrayToBst.sortedArrayToBST(new int[]{}));
    }

    @Test
    void single() {
        assertBoth(arr(42));
    }

    @Test
    void twoElements() {
        assertBoth(arr(1, 2));
    }

    @Test
    void oddLength() {
        assertBoth(arr(-3, -1, 0, 5, 9));
    }

    @Test
    void evenLength() {
        assertBoth(arr(1, 2, 3, 4, 5, 6));
    }

    @Test
    void withExtremes() {
        assertBoth(arr(Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE));
    }

    @Test
    void largerSequence() {
        int n = 31; // nice complete-tree size
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i - 15;
        assertBoth(nums);
    }

}