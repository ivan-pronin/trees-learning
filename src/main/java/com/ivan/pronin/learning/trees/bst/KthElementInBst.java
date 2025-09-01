package com.ivan.pronin.learning.trees.bst;

import java.util.ArrayDeque;
import java.util.Deque;

import com.ivan.pronin.learning.trees.model.TreeNode;
import com.ivan.pronin.learning.trees.util.Trees;

/**
 * @author Ivan Pronin
 * @since 01.09.2025
 */
public class KthElementInBst {

    // in-order traversal Left -> Root -> Right
    public static int getKthSmallest(int k, TreeNode<Integer> root) {
        if ( k < 1 || k > Trees.getSize(root)) throw new IllegalArgumentException("k index is out of bounds [1; <tree-size>]");
        if (null == root) throw new IllegalArgumentException("Tree is null");
        var current = root;
        var counter = 0;
        Deque<TreeNode<Integer>> nodes = new ArrayDeque<>();
        while (current != null || !nodes.isEmpty()){
            while (current != null){
                nodes.push(current);
                current = current.getLeft();
            }
            current = nodes.pop();
            counter++;
            if (counter == k) return current.getValue();
            current = current.getRight();
        }
        throw new IllegalArgumentException("Should not reach until this point");
    }

    // reversed in-order: Right - Root - Left
    public static int getKthLargest(int k, TreeNode<Integer> root) {
        if ( k < 1 || k > Trees.getSize(root)) throw new IllegalArgumentException("k index is out of bounds [1; <tree-size>]");
        if (null == root) throw new IllegalArgumentException("Tree is null");
        var current = root;
        var counter = 0;
        Deque<TreeNode<Integer>> nodes = new ArrayDeque<>();
        while (current != null || !nodes.isEmpty()){
            while (current != null){
                nodes.push(current);
                current = current.getRight();
            }
            current = nodes.pop();
            counter++;
            if (counter == k) return current.getValue();
            current = current.getLeft();
        }
        throw new IllegalArgumentException("Should not reach until this point");
    }

}
