package com.ivan.pronin.learning.trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 26.08.2025
 *
 * You’re given the root of a binary tree. Traverse the nodes level by level, but alternate direction on each level:
 * Level 0: left → right
 * Level 1: right → left
 * Level 2: left → right, etc.
 *
 * Two common output formats:
 * Zig-zag level order: List<List<Integer>>, one list per level in alternating order.
 * Spiral order (flat): List<Integer> flattened zig-zag across all levels.
 *
 * Example tree:
 *
 * ***** 1
 * *** /   \
 * ** 2     3
 * * / \     \
 * * 4   5    6
 *
 * Zig-zag levels: [[1], [3, 2], [4, 5, 6]]
 * Spiral flat: [1, 3, 2, 4, 5, 6]
 */
public class ZigzagOrderTraversal {

    public static <T> void traverse(TreeNode<T> root) {
        Stack<TreeNode<T>> nodesLeftToRight = new Stack<>();
        Stack<TreeNode<T>> nodesRightToLeft = new Stack<>();
        nodesLeftToRight.push(root);
        while (!nodesLeftToRight.isEmpty()) {
            while (!nodesLeftToRight.isEmpty()) {
                var current = nodesLeftToRight.pop();
                System.out.print(current.value() + "->");
                if (current.left() != null) nodesRightToLeft.push(current.left());
                if (current.right() != null) nodesRightToLeft.push(current.right());
            }
            while (!nodesRightToLeft.isEmpty()) {
                var current = nodesRightToLeft.pop();
                System.out.print(current.value() + "->");
                if (current.right() != null) nodesLeftToRight.push(current.right());
                if (current.left() != null) nodesLeftToRight.push(current.left());
            }
        }
    }

    /*
     * Time : O(N), N - total nodes in a Tree
     * Space: O(2W) + O(N) -> O(W) + O(N) -> O(N)
     */
    public static <T> List<List<T>> getTraversalList(TreeNode<T> root) {
        Stack<TreeNode<T>> nodesLeftToRight = new Stack<>();
        Stack<TreeNode<T>> nodesRightToLeft = new Stack<>();
        nodesLeftToRight.push(root);
        List<List<T>> result = new ArrayList<>();
        while (!nodesLeftToRight.isEmpty()) {
            List<T> lvlList = new ArrayList<>();
            while (!nodesLeftToRight.isEmpty()) {
                var current = nodesLeftToRight.pop();
                lvlList.add(current.value());
                if (current.left() != null) nodesRightToLeft.push(current.left());
                if (current.right() != null) nodesRightToLeft.push(current.right());
            }
            if (!lvlList.isEmpty()) result.add(lvlList);
            lvlList = new ArrayList<>();
            while (!nodesRightToLeft.isEmpty()) {
                var current = nodesRightToLeft.pop();
                lvlList.add(current.value());
                if (current.right() != null) nodesLeftToRight.push(current.right());
                if (current.left() != null) nodesLeftToRight.push(current.left());
            }
            if (!lvlList.isEmpty()) result.add(lvlList);
        }
        return result;
    }

}
