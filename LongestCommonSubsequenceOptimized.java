public class LongestCommonSubsequenceOptimized {

    public static void main(String[] args) {
        // Two DNA strands to check for differences
        String strandX = "ACGTACGT";
        String strandY = "TGCAAGCT";

        // Calculate and print the DNA strands differences
        String differences = findDNADifferences(strandX, strandY);
        System.out.println("DNA Strands Differences: " + differences);
    }

    // Function to find the differences between two DNA strands
    public static String findDNADifferences(String strandX, String strandY) {
        int m = strandX.length();
        int n = strandY.length();

        // Create a table to store differences
        char[][] differencesTable = new char[m + 1][n + 1];

        // Fill the table with differences
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                differencesTable[i][j] = ' '; // Initialize with empty space
            }
        }

        // Traverse the table to find differences
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (strandX.charAt(i - 1) == strandY.charAt(j - 1)) {
                    differencesTable[i][j] = ' '; // No difference
                } else {
                    differencesTable[i][j] = '*'; // Mark as difference
                }
            }
        }

        // Reconstruct the differences from the table
        StringBuilder differences = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (differencesTable[i][j] == '*') {
                differences.insert(0, strandX.charAt(i - 1) + " != " + strandY.charAt(j - 1) + ", ");
            }
            i--;
            j--;
        }

        return differences.toString();
    }
}
