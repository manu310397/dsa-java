public class ShortestWayToFormString_LC_1055 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "abcbc";

        System.out.println(f(s, t));
    }

    private static int f(String s, String t) {
        int targetIndex = 0;
        int subsequenceCount = 0;

        while (targetIndex < t.length()) {
            int sourceIndex = 0;
            boolean foundMatch = false;

            while (sourceIndex < s.length()) {
                if (s.charAt(sourceIndex) == t.charAt(targetIndex)) {
                    targetIndex++;
                    foundMatch = true;
                }
                sourceIndex++;
            }

            if (!foundMatch) {
                return -1;
            }

            subsequenceCount++;
        }

        return subsequenceCount;
    }
}