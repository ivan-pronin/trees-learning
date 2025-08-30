package com.ivan.pronin.learning.trees.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ivan.pronin.learning.trees.model.TreeNode;

/**
 * @author Ivan Pronin
 * @since 30.08.2025
 */
public class SerDeserBinaryTree {

    private static final String SEPARATOR = ",";

    private static final String NULL = "#";

    public static class PreOrder {

        public static String serialize(TreeNode<Integer> root) {
            if (null == root) return null;
            var strBuilder = new StringBuilder();
            serialize(root, strBuilder);
            strBuilder.deleteCharAt(strBuilder.length() - 1);
            return strBuilder.toString();
        }

        private static void serialize(TreeNode<Integer> root, StringBuilder strBuilder) {
            if (root == null) {
                strBuilder.append(NULL).append(SEPARATOR);
                return;
            }
            strBuilder.append(root.getValue()).append(SEPARATOR);
            serialize(root.getLeft(), strBuilder);
            serialize(root.getRight(), strBuilder);
        }

        public static TreeNode<Integer> deserialize(String serializedTree) {
            if (null == serializedTree || serializedTree.isEmpty()) return null;
            Queue<String> nodes = new ArrayDeque<>(Arrays.asList(serializedTree.split(SEPARATOR)));
            return deserialize(nodes);
        }

        private static TreeNode<Integer> deserialize(Queue<String> nodes) {
            var current = nodes.poll();
            if (current.equals(NULL)) return null;
            return new TreeNode<>(Integer.parseInt(current), deserialize(nodes), deserialize(nodes));
        }

    }

    public static class BfsIterative {

        public static String serialize(TreeNode<Integer> root) {
            if (null == root) return null;
            List<String> result = new ArrayList<>();
            List<TreeNode<Integer>> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                var current = nodes.removeFirst();
                if (null == current) {
                    result.add(NULL);
                } else {
                    result.add(String.valueOf(current.getValue()));
                    nodes.add(current.getLeft());
                    nodes.add(current.getRight());
                }
            }
            // remove trailing nulls
            int i = result.size() - 1;
            while (i >= 0 && result.get(i).equals(NULL)) i--;
            result = result.subList(0, i + 1);
            return String.join(SEPARATOR, result);
        }

        public static TreeNode<Integer> deserialize(String tree) {
            if (null == tree || tree.isEmpty()) return null;
            String[] tokens = tree.split(SEPARATOR);
            int idx = 0;
            var root = new TreeNode<>(Integer.parseInt(tokens[idx++]), null, null);
            Queue<TreeNode<Integer>> nodes = new LinkedList<>();
            nodes.offer(root);
            while (!nodes.isEmpty() && idx < tokens.length) {
                var current = nodes.poll();
                // left
                if (idx < tokens.length) {
                    var value = tokens[idx++];
                    if (!value.equals(NULL)){
                        var left = new TreeNode<>(Integer.parseInt(value), null, null);
                        current.setLeft(left);
                        nodes.offer(left);
                    }
                }
                // right
                if (idx < tokens.length) {
                    var value = tokens[idx++];
                    if (!value.equals(NULL)){
                        var right = new TreeNode<>(Integer.parseInt(value), null, null);
                        current.setRight(right);
                        nodes.offer(right);
                    }
                }

            }
            return root;
        }

    }

    public static class PostOrder {

        public static <T> String serialize(TreeNode<T> root) {
            return "";
        }

        public static <T> TreeNode<T> deserialize(String tree) {
            return null;
        }

    }

}
