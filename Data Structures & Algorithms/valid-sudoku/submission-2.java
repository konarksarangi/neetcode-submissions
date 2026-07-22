class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rows[][] = new boolean[9][9];
        boolean columns[][] = new boolean[9][9];
        boolean subBoxes[][] = new boolean[9][9];

        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char current = board[i][j];
                if(current == '.'){
                    continue;
                }
                int numIndex=current-'1';

                int boxIndex=(i/3)*3 + (j/3);

                if(rows[i][numIndex] || columns[j][numIndex] || subBoxes[boxIndex][numIndex]){
                    return false;
                }
                rows[i][numIndex]=true;
                columns[j][numIndex]=true;
                subBoxes[boxIndex][numIndex]=true;

            }
        }
        return true;
    }
}
