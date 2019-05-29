import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * create by Canon4G 2019-05-28
 **/
public class BinaryTreeTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(new Integer[] {
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        }));
        BinaryTreeTest binaryTreeTest = new BinaryTreeTest();
        TreeNode binaryTree = binaryTreeTest.createBinaryTree(linkedList);
        System.out.println("迭代前序遍历：");
        preorderTraversal(binaryTree);
        System.out.println();
        System.out.println("非迭代前序遍历：");
        preorderTraversalByStack(binaryTree);
        System.out.println();
        System.out.println("<============>");
        System.out.println("迭代中序遍历：");
        inorderTraversal(binaryTree);
        System.out.println();
        System.out.println("非迭代中序遍历：");
        inorderTraversalByStack(binaryTree);
        System.out.println();
        System.out.println("<============>");
        System.out.println("迭代后序遍历：");
        postorderTraversal(binaryTree);
        System.out.println();
        System.out.println("非迭代后序遍历：");
        postorderTraversalByStack(binaryTree);
    }

    /**
     * 创建二叉树
     * @param list      列表
     */
    private static TreeNode createBinaryTree(LinkedList<Integer> list) {
        TreeNode treeNode = null;
        if (null == list || list.isEmpty()) {
            return null;
        }
        Integer data = list.removeFirst();
        if (null != data) {
            treeNode = new TreeNode(data);
            treeNode.leftNode = createBinaryTree(list);
            treeNode.rightNode = createBinaryTree(list);
        }
        return treeNode;
    }

    /**
     * 二叉树前序遍历
     * @param node      二叉树节点
     */
    private static void preorderTraversal(TreeNode node) {
        if (null == node) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.leftNode);
        preorderTraversal(node.rightNode);

    }

    /**
     * 二叉树中序遍历
     * @param node      二叉树节点
     */
    private static void inorderTraversal(TreeNode node) {
        if (null == node) {
            return;
        }
        inorderTraversal(node.leftNode);
        System.out.print(node.data + " ");
        inorderTraversal(node.rightNode);
    }

    /**
     * 二叉树后续遍历
     * @param node      二叉树节点
     */
    private static void postorderTraversal(TreeNode node) {
        if (null == node) {
            return;
        }
        postorderTraversal(node.leftNode);
        postorderTraversal(node.rightNode);
        System.out.print(node.data + " ");
    }

    /**
     * 通过栈前序遍历
     * @param root      二叉树根节点
     */
    private static void preorderTraversalByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (null != treeNode || !stack.isEmpty()) {
            while (null != treeNode) {
                // 迭代访问节点的左孩子节点，入栈
                System.out.print(treeNode.data + " ");
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            // 如果节点没有左孩子节点，出栈，访问节点右孩子节点
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightNode;
            }
        }
    }

    /**
     * 通过栈中序遍历
     * @param root      二叉树根节点
     */
    private static void inorderTraversalByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (null != treeNode || !stack.isEmpty()) {
            while (null != treeNode) {
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            treeNode = stack.pop();
            System.out.print(treeNode.data + " ");
            treeNode = treeNode.rightNode;
        }
    }

    /**
     * 通过栈后序遍历
     * @param root      二叉树根节点
     */
    private static void postorderTraversalByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode last = null;
        while (null != treeNode || !stack.isEmpty()) {
            while (null != treeNode) {
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            treeNode = stack.peek();
            if (null != treeNode.rightNode && last != treeNode.rightNode) {
                treeNode = treeNode.rightNode;
            } else if ((null == treeNode.rightNode) || (last == treeNode.rightNode)) {
                System.out.print(treeNode.data + " ");
                last = treeNode;
                stack.pop();
                treeNode = null;
            }

        }
    }

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
