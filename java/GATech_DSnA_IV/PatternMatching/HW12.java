import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

/**
 * Your implementations of the Boyer Moore string searching algorithm.
 */
public class HW12 {


    public static void main(String[] args) {
        HW12 h = new HW12();
        System.out.println(HW12.boyerMoore("aba", "abacbabadcabacab", h.new CharacterComparator()));
        System.out.println(HW12.boyerMoore("aba", "aaabbbbababababbababab", h.new CharacterComparator()));
        System.out.println(HW12.boyerMoore("happy", "because im happy", h.new CharacterComparator()));
    }    

    /**
     * Boyer Moore algorithm that relies on a last occurrence table.
     * This algorithm Works better with large alphabets.
     *
     * Make sure to implement the buildLastTable() method, which will be
     * used in this boyerMoore() method.
     *
     * Note: You may find the getOrDefault() method from Java's Map class useful.
     *
     * You may assume that the passed in pattern, text, and comparator will not be null.
     *
     * @param pattern    The pattern you are searching for in a body of text.
     * @param text       The body of text where you search for the pattern.
     * @param comparator You MUST use this to check if characters are equal.
     * @return           List containing the starting index for each match found.
     */
    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        Map<Character, Integer> lastCount = buildLastTable(pattern);
        List<Integer> ind = new LinkedList<>();
        
        int i = 0;
        while(i <= text.length() - pattern.length()) {
            int j = pattern.length() - 1;
            while (j >= 0 && comparator.compare(text.charAt(i+j),pattern.charAt(j)) == 0) {
                j--;
            }
            
            if (j < 0) {
                ind.add(i);
                i++;
            } else {
                int shift = lastCount.getOrDefault(text.charAt(i+j), -1);
                if (shift < j) {
                    i += j - shift;
                } else {
                    i++;
                }
            }
        }
    
        return ind;
    
    }

    /**
     * Builds the last occurrence table that will be used to run the Boyer Moore algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. pattern = octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     * You may assume that the passed in pattern will not be null.
     *
     * @param pattern A pattern you are building last table for.
     * @return A Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern.
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Character c;
        HashMap<Character, Integer> rm = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            c = pattern.charAt(i);
            rm.put(c,i);
        }
        return rm;
    }


    public class CharacterComparator implements Comparator<Character> {

        private int comparisonCount;

        /**
         * To be used when comparing characters. Keeps count of
         * how many times this method has been called.
         *
         * @param a First character to be compared.
         * @param b Second character to be compared.
         * @return  Negative value if a is less than b, positive
         *          if a is greater than b, and 0 otherwise.
         */
        @Override
        public int compare(Character a, Character b) {
            comparisonCount++;
            return a - b;
        }

        /**
         * Gets the number of times compare has been used.
         *
         * @return The comparison count.
         */
        public int getComparisonCount() {
            return comparisonCount;
        }
    }

}    

