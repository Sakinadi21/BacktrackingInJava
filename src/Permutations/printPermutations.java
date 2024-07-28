package Permutations;

public class printPermutations {
    // Recursive function to print all permutations of the given string 'str'
    // 't' is the accumulating result string
    public static void printp(String str, String t) {
        // Base case: if 'str' is empty, print the accumulated result 't'
        if (str.isEmpty()) {
            System.out.println(t);
            return;
        }

        // Iterate over the characters in 'str'
        for (int i = 0; i < str.length(); i++) {
            // Extract the character at index 'i'
            char ch = str.charAt(i); // current character

            // Create a new string excluding the character at index 'i'
            String left = str.substring(0, i); // substring before 'ch'
            String right = str.substring(i + 1); // substring after 'ch'
            String rem = left + right; // remaining string without 'ch'

            // Recursively call printp with the remaining string and accumulated result
            printp(rem, t + ch);
        }
    }

    public static void main(String[] args) {
        // Define the input string
        String str = "abc";

        // Start printing permutations with an empty accumulated result
        printp(str, "");
    }
}
