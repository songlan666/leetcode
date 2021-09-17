public class StrToInt {
    public static void main(String[] args) {
        String s = "2147";
        Solution solution = new Solution();
        int b = solution.strToInt(s);
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(b);
    }
}

class Solution {
    public int strToInt(String str) {
        if (str.trim().length() == 0 || str == null) return 0;
        char[] temp = str.trim().toCharArray();
        if (temp.length == 0 || temp == null) return 0;
        int sign = 1;
        int i = 1;
        int result = 0;
        if (temp[0] == '-') sign = -1;
        else if(temp[0] != '+') i = 0;

        for (int j = i; j < temp.length; j++) {
            if (temp[j] < '0' || temp[j] > '9') break;
            if (result >= Integer.MAX_VALUE / 10) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + (temp[j] - '0');
        }
        return result * sign;
    }
}