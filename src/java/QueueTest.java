/**
 * create by Canon4G 2019-05-27
 **/
public class QueueTest {

    public static void main(String[] args) throws Exception {

        QueueTest queueTest = new QueueTest(5);
        queueTest.enterQueue(1);
        queueTest.enterQueue(2);
        queueTest.outQueue();
        queueTest.enterQueue(3);
        queueTest.enterQueue(4);
        queueTest.enterQueue(5);
        queueTest.outQueue();
        queueTest.enterQueue(6);
        queueTest.print();

    }

    // TODO: 队尾下标+1 % 数组长度 = 队头下标  ---->> 队列是满的

    private int[] arr;
    private int head;
    private int end;

    public QueueTest(int capacity) {
        this.arr = new int[capacity];
    }

    /**
     * 入队
     * @param element       入队元素
     *
     * 时间复杂度: O(1)
     */
    private void enterQueue(int element) throws Exception {
        if ((end + 1) % arr.length == head) {
            throw new Exception("队列已满");
        }
        arr[end] = element;
        end = (end + 1) % arr.length;
    }

    /**
     * 出队
     *
     * 时间复杂度: O(1)
     */
    private void outQueue() throws Exception {
        if (head == end) {
            throw new Exception("队列为空");
        }
        head = (head + 1) % arr.length;
    }

    /**
     * 打印
     */
    private void print() {
        for (int i = head; i != end; i = (i + 1) % arr.length) {
            System.out.print(arr[i] + " ");
        }
    }
}
