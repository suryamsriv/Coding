public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String alphanumeric = "";
        for (var ch : s.toCharArray()) {
            if (ch >= 97 && ch <= 122 || ch >= 48 && ch <= 57)
                alphanumeric += ch;
        }
        return checkPalindrome(alphanumeric);
    }

    public boolean checkPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }
}
