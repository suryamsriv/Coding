import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        List<Character> openingBrackets = new ArrayList<>(Arrays.asList('(', '{', '['));
        List<Character> closingBrackets = new ArrayList<>(Arrays.asList(')', '}', ']'));
        for (var ch : s.toCharArray()) {
            if (openingBrackets.contains(ch)) {
                stack.push(ch);
            } else if (closingBrackets.contains(ch)) {
                if (stack.isEmpty())
                    return false;

                var currentBracket = stack.pop();
                boolean match = false;

                switch (currentBracket) {
                    case '(':
                        if (ch == ')')
                            match = true;
                        break;
                    case '{':
                        if (ch == '}')
                            match = true;
                        break;
                    case '[':
                        if (ch == ']')
                            match = true;
                        break;
                    default:
                        throw new IllegalStateException();
                }
                if (!match)
                    return false;
            } else {
                throw new IllegalStateException();
            }
        }
        return stack.isEmpty();
    }
}