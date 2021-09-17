import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class LastRemaining {
    public static void main(String[] args) {
        String[][] s = new String[10][];
        System.out.println(s[1]);
    }
}

class Solution {
    public int lastRemaining(int n, int m) {

// 数学的方法：
        // int result = 0;
        // // 最后一轮剩下2个人，所以从2开始反推
        // for (int i = 2; i <= n; i++) {
        //     result = (result + m) % i;
        // }
        // return result;

// 模拟方法：
        List<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);

    }
}


class Solution1 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return order;
    }
}
