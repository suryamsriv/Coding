public class Main {
    public static void main(String args[]) {
        var input = new ValidParantheses();
        System.out.println(input.isValid("()"));
        System.out.println(input.isValid("()[]{}"));
        System.out.println(input.isValid("(]"));
        System.out.println(input.isValid("]"));
    }
}
