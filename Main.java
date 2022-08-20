public class Main {
    public static void main(String args[]) {

        var prefix = new LongestCommonPrefix();
        String[] strs = { "flower" };
        String[] strs2 = { "dog", "racecar", "car" };
        String[] strs3 = { "cir", "car" };
        System.out.println(prefix.longestCommonPrefix(strs2));
        // var input = new ValidParantheses();
        // System.out.println(input.isValid("()"));
        // System.out.println(input.isValid("()[]{}"));
        // System.out.println(input.isValid("(]"));
        // System.out.println(input.isValid("]"));
    }
}
