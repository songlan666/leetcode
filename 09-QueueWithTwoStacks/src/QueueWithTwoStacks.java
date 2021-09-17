import java.util.Stack;

public class QueueWithTwoStacks {
    public static void main(String[] args) {
        // int[] value = {{[]},{[3]},{[]},{[]}};
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.appendTail(5);
        obj.appendTail(3);
        // int param_2 = obj.deleteHead();
        // System.out.println(param_2);
        System.out.println("队列出队的第" + "1" + "个是：" + obj.deleteHead());
        System.out.println("队列出队的第" + "2" + "个是：" + obj.deleteHead());
        System.out.println("队列出队的第" + "3" + "个是：" + obj.deleteHead());

    }
}

class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int delete = stack2.pop();
            return delete;
        }
    }
}

