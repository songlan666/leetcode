
public class Node {
    //数据
    int data;

    //下一个节点
    Node next;

    Node before;

    //创建一个无参数构造方法，用于初始化
    public Node() {
    }

    //创建一个有参数构造方法，便于给结点传数据
    public Node(int data) {
        this.data = data;
    }

}