import java.util.ArrayDeque;
import java.util.Queue;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        Queue<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < strs.length; i++) {
            String prefix = "";
            for (char ch : strs[i].toCharArray()) {
                if (i == 0)
                    queue.add(ch);
                else {
                    if (!queue.isEmpty() && ch == queue.remove())
                        prefix += ch;
                    else
                        break;
                }
            }
            if (prefix != "") {
                queue.clear();
                for (char c : prefix.toCharArray())
                    queue.add(c);
            } else {
                if (i != 0) {
                    queue.clear();
                    break;
                }
            }
        }

        String prefix = "";

        while (!queue.isEmpty()) {
            prefix += queue.remove();
        }

        return prefix;
    }
}