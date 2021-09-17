import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String s = "veli";
        String str = "live";
        Solut solut = new Solut();
        boolean ch  = solut.Anagram(s, str);
        System.out.println(ch);
    }
}

class Solut {
    public boolean Anagram(String s, String str) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() == 0 || str.length() == 0 || str.length() != s.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }
}