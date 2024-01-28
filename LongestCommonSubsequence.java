import java.util.ArrayList;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        // Two sequences to find the LCS for
        String sequenceX = "ABCBDAB";
        String sequenceY = "BDCAB";

        // Calculate and print the LCS
        String lcs = findLCS(sequenceX, sequenceY);
        System.out.println("Longest Common Subsequence: " + lcs);
    }

    // Function to find the LCS between two sequences
    public static String findLCS(String X, String Y) {
        // Create a table to store lengths of common subsequences
        ArrayList<ArrayList<Integer>> lcsTable = new ArrayList<>();

        // Fill the table with LCS lengths
        for (int i = 0; i <= X.length(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= Y.length(); j++) {
                  row.add(0);
            }
            lcsTable.add(row);
        }

        // Traverse the table to find LCS lengths
        for (int i = 1; i <= X.length(); i++) {
            for (int j = 1; j <= Y.length(); j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lcsTable.get(i).set(j, lcsTable.get(i - 1).get(j - 1) + 1);
                } else {
                    lcsTable.get(i).set(j, Math.max(lcsTable.get(i - 1).get(j), lcsTable.get(i).get(j - 1)));
                }
            }
        }

        // Reconstruct the LCS from the table
        StringBuilder lcs = new StringBuilder();
        int i = X.length(), j = Y.length();
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.insert(0, X.charAt(i - 1));
                i--;
                j--;
            } else if (lcsTable.get(i - 1).get(j) >= lcsTable.get(i).get(j - 1)) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }
}
