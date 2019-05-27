/**
 * create by Canon4G 2019-05-27
 **/
public class StackTest {

    public static void main(String[] args) throws Exception {
        StackTest stackTest = new StackTest();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);
        stackTest.print();
        stackTest.pop();
        stackTest.print();
    }

    // 栈底
    private StackNode bottom;
    // 栈顶
    private StackNode top;
    // 栈大小
    private int size;

    /**
     * 压栈
     * @param data      元素
     *
     * 时间复杂度: O(1)
     */
    private void push(int data) {
        StackNode stackNode = new StackNode(data);
        // 空栈
        if (0 == size) {
            bottom = stackNode;
            top = stackNode;
            stackNode.next = null;
        } else {
            // 非空栈
            top.next = stackNode;
            stackNode.prev = top;
            top = stackNode;
        }
        size++;
    }

    /**
     * 出栈
     *
     * 时间复杂度: O(1)
     */
    private void pop() throws Exception {
        if (0 == size) {
            throw new Exception("栈已经为空");
        }
        // 获得栈顶的上一个元素
        StackNode stackNode = top.prev;
        // 栈顶弹出栈
        stackNode.next = null;
        // 创建新的栈顶
        top = stackNode;
        // 栈的大小减少
        size--;
    }

    /**
     * 打印
     */
    private void print() {
        StackNode stackNode = bottom;
        while (null != stackNode) {
            System.out.print(stackNode.data + " ");
            stackNode = stackNode.next;
        }
        System.out.println();
    }

    /**
     * 栈的节点
     */
    private static class StackNode {
        private int data;
        private StackNode next;
        private StackNode prev;

        public StackNode(int data) {
            this.data = data;
        }
    }
}
