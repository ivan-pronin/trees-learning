package com.ivan.pronin.learning.trees.bst;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 01.09.2025
 */
public class SortedArrayToBst {

    public static TreeNode<Integer> sortedArrayToBST(int[] array) {
        if (null == array || array.length == 0) return null;
        return buildNode(0, array.length - 1, array);
    }

    private static TreeNode<Integer> buildNode(int left, int right, int[] arr){
        if (left > right) return null;
        int mid = (left + right + 1) / 2;
        var node = new TreeNode<>(arr[mid]);
        node.setLeft(buildNode(left, mid - 1, arr));
        node.setRight(buildNode(mid + 1, right, arr));
        return node;
    }

}
