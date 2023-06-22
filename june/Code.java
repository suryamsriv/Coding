package june;

public class Code {
    public static void main(String arg[]) {
        Code obj = new Code();
        System.out.println(obj.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder(s.trim());
        StringBuilder rev = new StringBuilder();
        int index = str.length();
        while(index > 0) {
            int spaceIndex = findSpace(str.toString().trim(), index);
            if(spaceIndex != -1) {
                rev.append(str.substring(spaceIndex, index).trim() + " ");
                str.delete(spaceIndex, index);
                index = spaceIndex;
            }
            else {
                rev.append(str.substring(0, index).trim());
                break;
            }
        }
        return rev.toString().trim();
    }

    private int findSpace(String str, int index) {
        return str.lastIndexOf(' ', index - 1);
    }
}
