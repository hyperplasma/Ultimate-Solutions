package DataStructure.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {
    Queue<Integer> minHeap = new PriorityQueue<>(); // 小根堆
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // 大根堆
}
