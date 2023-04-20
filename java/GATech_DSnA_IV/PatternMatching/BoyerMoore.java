import java.util.Map;
import java.util.HashMap;

public class BoyerMoore {
    private Map<Character, Integer> PatternLastCountTable;
    private String pattern;


    BoyerMoore(String pattern) {
        this.PatternLastCountTable = new HashMap<>();
        this.populateLastCounts(pattern);
        this.pattern = pattern;
    }

    private void populateLastCounts(String pattern) {
        Character c;
        for (int i = 0; i < pattern.length(); i++) {
            c = pattern.charAt(i);
            this.PatternLastCountTable.put(c, i);
        }
    }

    public int findPatternIn(String string) {

        int i = 0;
        while (i <= string.length() - pattern.length()) {
            int j = pattern.length() - 1;
            
            while (j >= 0 && string.charAt(i+j) == this.pattern.charAt(j)) {
                j--;
            }

            if (j < 0) {
                return i;
            } else {
                int shift = this.PatternLastCountTable.getOrDefault(string.charAt(i+j), -1);
                if (shift < j) {
                    i += j - shift;
                } else {
                    i++;
                }
            }
        }

        return -1;
    };

    public static void main(String[] args) {

        BoyerMoore bm1 = new BoyerMoore("abacab");
        String s1 = "abacbabadcabacab";

        BoyerMoore bm2 = new BoyerMoore("happy");
        String s2 = "because im happy";

        System.out.println("result 1: " + bm1.findPatternIn(s1));
        System.out.println("result 2: " + bm2.findPatternIn(s2));

    }

}
