import java.util.Arrays; 

public class KnuthMorrisPratt {
    private int[] failureTable;
    private String pattern;

    KnuthMorrisPratt(String pattern) {
        this.pattern = pattern;
        this.constructFailureTable();
    }

    private void constructFailureTable () {
        if (this.pattern.length() == 0) { this.failureTable = new int[0]; return; }

        this.failureTable = new int[this.pattern.length()];
        int i = 0;
        int j = 1;
        while (j < this.pattern.length()) {
            if (this.pattern.charAt(i) == this.pattern.charAt(j)) {
                this.failureTable[j++] = ++i; continue;
            } 
            if (i == 0) {
                this.failureTable[j++] = i; continue;
            }
            i = this.failureTable[i-1];
        }
        System.out.println( this.pattern + " " + Arrays.toString(this.failureTable));
    }

    public int findPatternIn(String str) {
        int j = 0; int k = 0;
        while (k < str.length()) {
            if (this.pattern.charAt(j) == str.charAt(k)) {
                if (j == this.pattern.length() - 1) { 
                    // first occurence                    
                    return k + 1 - this.pattern.length();

                    // multi match
                    // System.out.println("match found: " + (k +1 - this.pattern.length()));  
                    // j = this.failureTable[this.pattern.length() - 1];
                    // System.out.println(k + ", " + j);
                }
                j++; k++;
                continue;
            }
            if (j == 0) {
                k++; continue;
            }
            j = this.failureTable[j-1];
        }
        return -1;
    }


    public static void main(String[] args) {
        KnuthMorrisPratt kmp1 = new KnuthMorrisPratt("revararev");
        KnuthMorrisPratt kmp2 = new KnuthMorrisPratt("thetha");
        System.out.println(kmp2.findPatternIn("the-theath-theathetha"));
        
        KnuthMorrisPratt kmp3 = new KnuthMorrisPratt("abababbab");  
        KnuthMorrisPratt kmp4 = new KnuthMorrisPratt("aba");
        System.out.println(kmp4.findPatternIn("aaabbbbababababbababab"));
    }


    
}
