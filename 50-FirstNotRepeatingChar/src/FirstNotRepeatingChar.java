import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        String s = "we are family w";
        Solution solution = new Solution();
        char ch  = solution.firstUniqChar(s);
        System.out.println(ch);
    }
}

class Solution {
    public char firstUniqChar(String s) {
        // Map<Character, Integer> frequency = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        // }
        // for (int i = 0; i < s.length(); i++) {
        //     if (frequency.get(s.charAt(i)) == 1) return s.charAt(i);

        // }
        // return ' ';

        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (frequency.get(ch) == 1) return ch;
        }
        return ' ';
    }
}
