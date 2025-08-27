package com.ivan.pronin.learning.trees.model;

/**
 * @author Ivan Pronin
 * @since 26.08.2025
 */
public record TreeNode<T>(
    T value,
    TreeNode<T> left,
    TreeNode<T> right) {

}
