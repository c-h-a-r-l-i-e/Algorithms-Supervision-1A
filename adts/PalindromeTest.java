package uk.ac.cam.cl.cm927.adts;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PalindromeTest {
    public static void main(String[] args) {
        System.out.println(test("aba"));
        System.out.println(test("abcddcba"));
        System.out.println(test("a"));
        System.out.println(test("abcb"));
        System.out.println(test("not"));
        System.out.println(test("aibohphobia"));
    }

    public static boolean test(String toTest) {
        Stack<Character> stack = new Stack<>();
        char[] arr = toTest.toCharArray();
        List<Character> chars = toTest.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        stack.addAll(chars);
        boolean palindrome = true;
        for (int i = 0; i < stack.size(); i++) {
            if (toTest.toCharArray()[i] != stack.pop()) palindrome = false;
        }
        return palindrome;
    }
}
