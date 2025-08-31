package com.ivan.pronin.learning.trees.bst;

import com.ivan.pronin.learning.trees.model.TreeNode;
import com.ivan.pronin.learning.trees.util.TreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 30.08.2025
 */
class ValidateBSTTest {

    @Test
    void shouldReturnTrueOnIsValidBst() {
        var root = TreeFactory.createSampleBST();
        Assertions.assertTrue(ValidateBST.isValidBstRecursive(root));
    }

    @Test
    void shouldReturnFalseOnIsValidBst() {
        var root = TreeFactory.createNonBstTree();
        Assertions.assertFalse(ValidateBST.isValidBstRecursive(root));
    }

    @Test
    void shouldReturnFalseForDeepTree() {
        var r = getNonValidBst();

        Assertions.assertFalse(ValidateBST.isValidBstRecursive(r));
    }

    @Test
    void shouldReturnTrueOnIsValidBstIterative() {
        var root = TreeFactory.createSampleBST();
        Assertions.assertTrue(ValidateBST.isValidBstIterative(root));
    }

    @Test
    void shouldReturnFalseOnIsValidBstIterative() {
        var root = TreeFactory.createNonBstTree();
        Assertions.assertFalse(ValidateBST.isValidBstIterative(root));
    }

    @Test
    void shouldReturnFalseForDeepTreeIterative() {
        final var r = getNonValidBst();

        Assertions.assertFalse(ValidateBST.isValidBstIterative(r));
    }

    //        5
    //      /   \
    //     3     7
    //          /
    //         4   <-- invalid: 4 is in the right subtree of 5
    private static TreeNode<Integer> getNonValidBst() {
        var r = new TreeNode<>(5);
        r.setLeft(new TreeNode<>(3));
        r.setRight(new TreeNode<>(7));
        r.getRight().setLeft(new TreeNode<>(4));
        return r;
    }

}