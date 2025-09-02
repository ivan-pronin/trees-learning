package com.ivan.pronin.learning.trees.general;

import com.ivan.pronin.learning.trees.model.TreeNode;
import com.ivan.pronin.learning.trees.util.TreeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ivan Pronin
 * @since 02.09.2025
 */
class FindMaxDiameterOfTreeTest {

    @Test
    void testReturnZero() {
        Assertions.assertEquals(0, FindMaxDiameterOfTree.getMaxDiameterWidth(null));
        Assertions.assertEquals(0, FindMaxDiameterOfTree.getMaxDiameterWidth(new TreeNode<>(1)));
    }

    @Test
    void testReturnMaxDiameterForBST() {
        var root = TreeFactory.createSampleBST4Levels();
        Assertions.assertEquals(5, FindMaxDiameterOfTree.getMaxDiameterWidth(root));
    }

    @Test
    void testReturnMaxDiameterForLineTree() {
        var root = TreeFactory.createLineTree();
        Assertions.assertEquals(3, FindMaxDiameterOfTree.getMaxDiameterWidth(root));
    }

}