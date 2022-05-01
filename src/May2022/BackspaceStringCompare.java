package May2022;

import java.util.Stack;

/**Question
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 */

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s1 = "ab##";
        String s2 = "c#d#";

        System.out.println(backspaceCompare(s1, s2));
    }

    //Time - O(N)
    //Space - O(N) - usage of stack
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch != '#'){
                stack.push(ch);
            }else{
                if(!stack.empty()){
                    stack.pop();
                }
            }
        }

        String s1 = "";
        while(!stack.empty()){
            s1+=stack.pop();
        }

        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch != '#'){
                stack.push(ch);
            }else{
                if(!stack.empty()){
                    stack.pop();
                }
            }
        }

        String s2 = "";
        while(!stack.empty()){
            s2+=stack.pop();
        }

        return s1.equals(s2);
    }

    //Time - O(N)
    //Space - O(1)

    /*
            Iterate through the string in reverse. If we see a backspace character, the next non-backspace character is skipped. If a character isn't skipped, it is part of the final answer.
            See the comments in the code for more details.
    */
    public boolean backspaceCompareOptimized(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}
