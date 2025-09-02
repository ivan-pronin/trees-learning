package com.ivan.pronin.learning.trees.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ivan Pronin
 * @since 02.09.2025
 */
class MinHeap0BasedTest {

    @Test
    void approach1_basicOps() {
        MinHeap0Based h = new MinHeap0Based();
        int[] vals = {5, 3, 8, 1, 4, 7, 2};
        for (int v : vals) h.offer(v);

        assertTrue(h.isValidHeap());
        assertEquals(7, h.size());
        assertEquals(1, h.peek());
        assertEquals(1, h.poll());
        assertEquals(2, h.poll());
        assertEquals(3, h.peek());
        assertTrue(h.isValidHeap());
        assertEquals(5, h.size());
    }

    @Test
    void approach1_sortedPolls() {
        List<Integer> in = Arrays.asList(9, 0, -3, 4, 4, 10, 2);
        MinHeap0Based h = MinHeap0Based.fromListIncremental(in);
        List<Integer> out = new ArrayList<>();
        while (!h.isEmpty()) out.add(h.poll());
        assertEquals(Arrays.asList(-3, 0, 2, 4, 4, 9, 10), out);
    }

    @Test
    void emptyBehavior() {
        MinHeap0Based h0 = new MinHeap0Based();
        assertThrows(NoSuchElementException.class, h0::peek);
        assertThrows(NoSuchElementException.class, h0::poll);
    }

    @Test
    void interleavedOps_keepHeapProperty() {
        MinHeap0Based h = new MinHeap0Based();
        h.offer(5); h.offer(1); h.offer(3); h.offer(9); h.offer(2);
        assertEquals(1, h.poll());
        h.offer(0);
        assertEquals(0, h.peek());
        assertTrue(h.isValidHeap());
    }

}