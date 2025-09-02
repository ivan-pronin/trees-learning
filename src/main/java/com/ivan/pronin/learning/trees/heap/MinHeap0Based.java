package com.ivan.pronin.learning.trees.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Ivan Pronin
 * @since 02.09.2025
 */
public class MinHeap0Based {

    private final List<Integer> array = new ArrayList<>();

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public void offer(int x) {
        array.add(x);
        siftUp(array.size() - 1);
    }

    public int peek() {
        if (array.isEmpty()) throw new NoSuchElementException("heap is empty");
        return array.getFirst();
    }

    public int poll() {
        if (array.isEmpty()) throw new NoSuchElementException("heap is empty");
        int res = array.getFirst();
        int last = array.removeLast();
        if (!array.isEmpty()) {
            array.set(0, last);
            siftDown(0);
        }
        return res;
    }

    private void siftUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2; //  (i - 1) >>> 1
            if (array.get(p) <= array.get(i)) break;
            swap(p, i);
            i = p;
        }
    }

    private void siftDown(int i) {
        int n = array.size();
        while (true) {
            int l = 2 * i + 1;   // (i << 1) + 1;
            int r = l + 1;       // 2i+2
            int smallest = i;
            if (l < n && array.get(l) < array.get(smallest)) smallest = l;
            if (r < n && array.get(r) < array.get(smallest)) smallest = r;
            if (smallest == i) break;
            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int i, int j) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    // Convenience: bulk insert (O(N log N))
    public static MinHeap0Based fromListIncremental(List<Integer> xs) {
        MinHeap0Based h = new MinHeap0Based();
        for (int v : xs) h.offer(v);
        return h;
    }

    // Validate min-heap order property (for tests)
    boolean isValidHeap() {
        for (int i = 1; i < array.size(); i++) {
            int p = (i - 1) >>> 1;
            if (array.get(p) > array.get(i)) return false;
        }
        return true;
    }

}
