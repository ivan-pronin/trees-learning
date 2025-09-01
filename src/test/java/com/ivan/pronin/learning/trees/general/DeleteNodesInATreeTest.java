package com.ivan.pronin.learning.trees.general;

import java.util.Arrays;
import java.util.List;

import com.ivan.pronin.learning.trees.model.TreeNode;
import com.ivan.pronin.learning.trees.util.TreeFactory;
import com.ivan.pronin.learning.trees.util.Trees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 01.09.2025
 */
class DeleteNodesInATreeTest {

    @Test
    void testExampleBasic() {
        /*
         * Example tree:
         *        1
         *      /   \
         *     2     3
         *    / \     \
         *   4   5     6
         */
        // Expected forests: [1,2,#,4], [6], [7]
        var root = TreeFactory.createSampleZigZagTree();
        List<TreeNode<Integer>> result = DeleteNodesInATree.deleteNodes(root, new int[]{3, 5});
        List<String> serializedResult = Trees.serializeForest(result);
        var expectedResult = Arrays.asList("1,2,#,4", "6");
        Assertions.assertEquals(expectedResult, serializedResult);
    }

    @Test
    void testDeleteRootOnly() {
        var root = TreeFactory.createSampleZigZagTree();
        List<TreeNode<Integer>> result = DeleteNodesInATree.deleteNodes(root, new int[]{1});
        List<String> serializedResult = Trees.serializeForest(result);
        var expectedResult = Arrays.asList("2,4,5", "3,#,6");
        Assertions.assertEquals(expectedResult, serializedResult);
    }

    @Test
    void testDeleteNone() {
        var root = TreeFactory.createSampleZigZagTree();
        List<TreeNode<Integer>> result = DeleteNodesInATree.deleteNodes(root, new int[]{});
        List<String> serializedResult = Trees.serializeForest(result);
        var expectedResult = List.of("1,2,3,4,5,#,6");
        Assertions.assertEquals(expectedResult, serializedResult);
    }

    @Test
    void testDeleteAll() {
        var root = TreeFactory.createSampleZigZagTree();
        List<TreeNode<Integer>> result = DeleteNodesInATree.deleteNodes(root, new int[]{1,2,3,4,5,6});
        List<String> serializedResult = Trees.serializeForest(result);
        var expectedResult = List.of();
        Assertions.assertEquals(expectedResult, serializedResult);
    }

}