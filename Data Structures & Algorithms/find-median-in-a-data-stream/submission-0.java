class MedianFinder {

    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        if(!largeHeap.isEmpty() && num > largeHeap.peek()) {
            largeHeap.add(num);
        } else {
            smallHeap.add(num);
        }

        //Rebalancing

        if(largeHeap.size() > smallHeap.size() + 1) {
            smallHeap.add(largeHeap.poll());
        }

        if(smallHeap.size() > largeHeap.size() + 1) {
            largeHeap.add(smallHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        } else if(largeHeap.size() > smallHeap.size()) {
            return largeHeap.peek();
        } else {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */