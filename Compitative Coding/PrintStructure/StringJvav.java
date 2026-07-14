//anagrams

package PrintStructure;
public class StringJvav {
    public static void main(String[] args) {
        String s1 = "Listen",s2 = "silent";
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() != s2.length()) {
            System.out.println("The strings are not anagrams.");
            return;
        }
        while (s1.length() > 0) {
            char ch = s1.charAt(0);
            s1 = s1.replace(String.valueOf(ch), "");
            s2 = s2.replace(String.valueOf(ch), "");
        }
        System.out.println("The strings are anagrams.");

    }
}
