/**
 * create by Canon4G 2019-05-27
 **/
public class SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insert(1, 0);
        linkedList.insert(2, 1);
        linkedList.insert(3, 2);
        linkedList.print();
        linkedList.insert(4, 1);
        linkedList.print();
        System.out.println(linkedList.search(1).data);
        linkedList.update(2, 0);
        linkedList.print();
        linkedList.delete(2);
        linkedList.print();
    }

    // 头节点
    private Node head;
    // 尾节点
    private Node end;
    // 链表大小
    private int size;

    /**
     * 新增
     * @param data      节点值
     * @param index     索引
     */
    private void insert(int data, int index) {
        if (0 > index || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node node = new Node(data);
        // 空链表不存在节点
        if (0 == size) {
            head = node;
            end = node;
            node.next = null;
        }
        // 头部插入
        if (0 < size && 0 == index) {
            node.next = head;
            head = node;
        } else if (size == index) {
            // 尾部插入
            end.next = node;
            end = node;
            node.next = null;
        } else {
            // 中间插入
            Node prevNode = search(index - 1);
            Node nextNode = prevNode.next;
            prevNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    /**
     * 删除
     * @param index     索引
     */
    private void delete(int index) {
        if (0 > index || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        if (0 != size) {
            // 删除头部节点
            if (0 == index) {
                Node node = search(index);
                node.next = head;
            }
            // 删除中部节点
            if (0 != index) {
                Node prevNode = search(index - 1);
                prevNode.next = search(index + 1);
            }
            // 删除尾部节点
            if (size == index) {
                Node node = search(index - 1);
                node.next = null;
                end = node;
            }
            size--;
        }
    }

    /**
     * 更新
     * @param data      节点值
     * @param index     索引
     */
    private void update(int data, int index) {
        if (0 > index || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        if (0 != size) {
            Node node = search(index);
            node.data = data;
        }
    }

    /**
     * 查询
     * @param index     索引
     */
    private Node search(int index) {
        if (0 > index || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点的范围");
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * 打印
     */
    private void print() {
        Node node = head;

        while (null != node) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 节点
     */
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
