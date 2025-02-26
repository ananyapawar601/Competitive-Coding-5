//HashSet Solution

//Time Complexity: O(1) — Since the board is always 9x9, we perform a constant number of operations (81), making it effectively constant time.
//Space Complexity: 

//O(1) — Each HashSet stores at most 9 elements at a time, which is a fixed amount of space.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Check each row for duplicate numbers.
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>(); // Set to track numbers in the row.
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue; // Ignore empty cells.
                if (seen.contains(board[row][i])) return false; // Duplicate found.
                seen.add(board[row][i]); // Add the number to the set.
            }
        }
    
        // Check each column for duplicate numbers.
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>(); // Set to track numbers in the column.
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue; // Ignore empty cells.
                if (seen.contains(board[i][col])) return false; // Duplicate found.
                seen.add(board[i][col]); // Add the number to the set.
            }
        }
    
        // Check each 3x3 sub-grid for duplicate numbers.
        for (int sq = 0; sq < 9; sq++) {
            Set<Character> seen = new HashSet<>(); // Set to track numbers in the sub-grid.
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Calculate the row and column indices for the current 3x3 grid.
                    int row = (sq / 3) * 3 + i;
                    int col = (sq % 3) * 3 + j;
                    
                    if (board[row][col] == '.') continue; // Ignore empty cells.
                    if (seen.contains(board[row][col])) return false; // Duplicate found.
                    seen.add(board[row][col]); // Add the number to the set.
                }
            }
        }
        
        // If no duplicates were found, the board is valid.
        return true;
    }
}