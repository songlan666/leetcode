import java.util.ArrayList;

public class NodeShow implements LinkList {
    // Node root=new Node();
    Node head = new Node();// 头节点
    // 尾节点
    Node tail;
    // 元素个数
    // Node next;
    int size;
    private int data;

    public NodeShow() {
        // 初始化头结点和尾节点
        head = new Node();
        tail = head;
        size = 0;
    }

    public void check(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("参数不对");
        }

    }

    public void add(int e) {

        // 创建一个新节点
        // next=new Node(obj);
        // if(size==0){
        // // root.
        // }
        Node node = new Node(e);
        // 尾节点的下一个节点，设为新节点
        tail.next = node;
        // 修改尾节点变为新节点
        tail = node;
        // 修改元素个数
        size++;

    }

    public void insert(int e, int index) {
        check(index);
        Node node1 = head.next;
        for (int i = 0; i < index; i++) {
            node1 = node1.next;// 找到index节点
        }
        Node node2 = new Node(e);
        if (index == 0) {// 如果插在最前面
            head.next = null;// 断开头结点和第一个节点
            head.next = node2;// 头结点指向第一个节点
            node2.next = node1;// 新节点指向原来第一节点
        } else {
            Node node3 = head.next;
            for (int i = 0; i < index - 1; i++) {
                node3 = node3.next;
            }
            node3.next = null;
            node3.next = node2;
            node2.next = node1;

        }
        size++;
    }

    public void delete(int index) {
        check(index);
        // 下标为index的节点
        Node node1 = head.next;
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                node1 = node1.next;

            }
            // 下标为index-1的节点，index的前一个节点
            Node node2 = head.next;
            for (int i = 0; i < index - 1; i++) {
                node2 = node2.next;
            }
            if (index != size - 1) {// 如果不是最后一个节点
                Node node3 = node1.next;// index的下一个节点
                node2.next = node3;// 将前一个节点指向后一个节点
                node1.next = null;// 断开前一个节点和index节点
            } else {
                node1.next = null;// 断开前一个节点和index节点
            }
            node1 = null;
            // node1.next=null;
        } else {
            Node node6 = head.next;
            Node node7 = node6.next;
            head.next = null;
            head.next = node7;
            node6.next = null;

        }
        size--;
    }

    public int get(int index) {

        Node node = head.next;
        // 从头节点开始，依次向后查找
        for (int i = 0; i < index; i++) {
            node = node.next;

        }
        return node.data;
    }

    @Override
    public void set(int data) {

    }

    public void update(int index, int e) {

        Node node1 = head.next;
        for (int i = 0; i < index; i++) {

            node1 = node1.next;

        }

        node1.data = e;

    }

    public int getSize() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public Node getNext() {
        return null;
    }

    @Override
    public void setNext(Node next) {

    }

    public static void main(String[] args) {
        // 创建链表
        NodeShow kk = new NodeShow();
        // 添加元素
        kk.add(55);
        kk.add(89);
        kk.add(18);
        kk.add(92);
        kk.add(562);
        kk.add(782);
        kk.add(45);
        kk.delete(4);
        kk.insert(666, 3);
        kk.update(4, 5555);
        for (int i = 0; i < kk.getSize(); i++) {
            int e = kk.get(i);
            System.out.println("第" + i + "个元素是：" + e);
        }
    }
}