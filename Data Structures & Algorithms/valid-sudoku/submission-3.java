class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] subBoxes = new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c=='.'){
                    continue;
                }
                int index=c-'1';
                int subBoxIndex=(i/3)*3 + j/3;
                if(rows[i][index] || columns[j][index] || subBoxes[subBoxIndex][index]){
                    return false;
                }
                rows[i][index]=true;
                columns[j][index]=true;
                subBoxes[subBoxIndex][index]=true;
            }
        }
        return true;
    }
}
