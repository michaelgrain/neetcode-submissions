class MedianFinder 
{
    // maxHeap хранит меньшую половину чисел (вершина - максимум)
    private PriorityQueue<Integer> maxHeap;
    // minHeap хранит большую половину чисел (вершина - минимум)
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() 
    {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) 
    {
        // 1. Кладём число в maxHeap (меньшая половина)
        maxHeap.offer(num);

        // 2. Перекладываем максимум из maxHeap в minHeap,
        //    чтобы гарантировать, что все элементы maxHeap <= элементов minHeap
        minHeap.offer(maxHeap.poll());

        // 3. Балансируем размеры: maxHeap может быть больше minHeap
        //    максимум на 1, но не наоборот
        if (minHeap.size() > maxHeap.size()) 
        {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() 
    {
        if (maxHeap.size() > minHeap.size()) 
        {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

