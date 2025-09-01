package com.ivan.pronin.learning.trees.util;

import com.ivan.pronin.learning.trees.model.TreeNode;
import lombok.experimental.UtilityClass;

/**
 * @author Ivan Pronin
 * @since 30.08.2025
 */
@UtilityClass
public class Trees {

    public static <T> boolean equals(TreeNode<T> first, TreeNode<T> second) {
        if (first == second) return true;
        if (first == null || second == null) return false;
        return first.getValue() == second.getValue() && equals(first.getLeft(), second.getLeft()) && equals(first.getRight(), second.getRight());
    }

    public static <T> int getSize(TreeNode<T> root){
        if (root == null) return 0;
        return 1 + getSize(root.getLeft()) + getSize(root.getRight());
    }


}
