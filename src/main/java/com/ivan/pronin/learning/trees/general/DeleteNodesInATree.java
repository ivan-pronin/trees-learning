package com.ivan.pronin.learning.trees.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 01.09.2025
 */
public class DeleteNodesInATree {

    public static List<TreeNode<Integer>> deleteNodes(TreeNode<Integer> root, int[] toDelete) {
        Set<Integer> del = new HashSet<>();
        for (int v : toDelete) del.add(v);
        List<TreeNode<Integer>> forest = new ArrayList<>();
        root = dfs(root, true, del, forest);
        return forest;
    }

    private static TreeNode<Integer> dfs(TreeNode<Integer> node, boolean isRoot, Set<Integer> del, List<TreeNode<Integer>> forest) {
        if (node == null) return null;

        boolean deleted = del.contains(node.getValue());
        node.setLeft(dfs(node.getLeft(), deleted, del, forest));
        node.setRight(dfs(node.getRight(), deleted, del, forest));

        if (deleted) {
            // Children (already processed) will have been added if they are roots & not deleted
            return null;
        } else {
            if (isRoot) forest.add(node);
            return node;
        }
    }

}
