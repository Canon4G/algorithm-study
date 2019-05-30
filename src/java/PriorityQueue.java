import java.util.Arrays;

/**
 * create by Canon4G 2019-05-30
 **/
public class PriorityQueue {

    private int[] array;
    private int size;

    public PriorityQueue(int capacity) {
        array = new int[capacity];
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue priorityQueue = new PriorityQueue(16);
        priorityQueue.enterQueue(1);
        priorityQueue.enterQueue(3);
        priorityQueue.enterQueue(10);
        priorityQueue.enterQueue(2);
        priorityQueue.enterQueue(7);
        System.out.println(Arrays.toString(priorityQueue.array));
        System.out.println("出队元素: " + priorityQueue.outQueue());
        System.out.println("出队元素: " + priorityQueue.outQueue());

    }

    /**
     * 入队
     * @param element       入队元素
     */
    private void enterQueue(int element) {
        if (size > array.length) {
            resize();
        }
        array[size++] = element;
        // 通过二叉堆的上浮操作实现优先队列的入队操作
        upAdjust();
    }

    /**
     * 出队
     */
    private int outQueue() throws Exception {
        if (size < 0) {
            throw new Exception("队列已经为空");
        }
        // 堆顶
        int head = array[0];
        // 最后一个元素放到堆顶
        array[0] = array[--size];
        // 通过二叉堆的下沉操作实现优先队列的出队操作
        downAdjust();
        return head;

    }

    /**
     * 上浮调整
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (0 < childIndex && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     */
    private void downAdjust() {
        int parentIndex = 0;
        int childIndex = (2 * parentIndex) + 1;
        int temp = array[parentIndex];
        while (childIndex < size) {
            // 右孩子节点存在 且 小于左孩子节点 选择右孩子节点
            if (childIndex + 1 < size && array[childIndex] > array[childIndex + 1]) {
                childIndex++;
            }
            // 父节点小于所有
            if (temp <= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = (2 * parentIndex) + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 扩容
     */
    private void resize() {
        int resizedSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, resizedSize);
    }
}
