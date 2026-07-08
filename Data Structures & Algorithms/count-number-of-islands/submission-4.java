class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;

        int islandCounter=0;

        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1'){
                    islandCounter++;
                }
                dfs(grid,i,j);
            }
        }
        return islandCounter;
    }

    private void dfs(char[][] grid, int row, int column){
        int rows = grid.length;
        int columns = grid[0].length;

        //Base case
        if(row<0 || column <0 || row>=rows || column >=columns || grid[row][column] == '0'){
            return;
        }

        grid[row][column]='0';

        dfs(grid,row+1,column);
        dfs(grid,row-1,column);
        dfs(grid,row,column+1);
        dfs(grid,row,column-1);
    }
}
