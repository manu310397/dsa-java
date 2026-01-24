import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        System.out.println(preToInfix("*-A/BC-/AKL"));
    }

    static String preToInfix(String p) {
        Stack<String> st = new Stack<>();

        for (int i = p.length() - 1; i >= 0; i--) {
            char c = p.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                st.push(c + "");
            } else {
                String s1 = st.pop();
                String s2 = st.pop();

                String s3 = "(" + s1 + c + s2 + ")";

                st.push(s3);
            }
        }

        return st.peek();
    }
}
