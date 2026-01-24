//https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
public class GFG1 {
    public static void main(String[] args) {
        String s1 = "mightandmagic";
        String s2 = "andmagicmigth";

        System.out.println(areRotations(s1, s2));
    }

    public static boolean areRotations(String s1, String s2) {
        // code here
        StringBuilder doubleString = new StringBuilder(s1).append(s1);

        int j = 0;
        for (int i = 0; i < doubleString.length(); i++) {
            while (j < s2.length() && doubleString.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }

            if (j == s2.length()) {
                return true;
            } else {
                j = 0;
            }
        }

        return false;
    }
}
