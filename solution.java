class Solution {
    String word1_;
    String word2_;
    
    public int minDistance(String word1, String word2) {
        word1_ = word1;
        word2_ = word2;
        int[][]arr = new int[word1_.length()][word2_.length()];
        for (int i = 0; i < word1_.length(); i++) {
            Arrays.fill(arr[i], -1);
        }
        return minDistance(0, 0, arr);
    }
    
    public int minDistance(int r, int c, int[][]arr) {
        if (c >= word2_.length()) { return word1_.length() - r; }
        if (r >= word1_.length()) { return word2_.length() - c; }
        if (arr[r][c] == -1) {
            int match = (word1_.charAt(r) == word2_.charAt(c)) ? 0 : 1;
            arr[r][c] = min(match + minDistance(r + 1, c + 1, arr), // replace
                            1 + minDistance(r, c + 1, arr), // insert
                            1 + minDistance(r + 1, c, arr)); // remove
        }
        return arr[r][c];
    }
    
    public int min(int a, int b, int c) {
        return Math.min((Math.min(a, b)), c);
    }
}
