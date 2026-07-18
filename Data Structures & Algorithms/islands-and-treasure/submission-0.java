class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j,0);
                }
            }
        }
        
    }

    private void dfs(int[][] grid, int row, int column, int distance){
        //Base case
        if(row<0 || column <0 || row>=grid.length || column>=grid[0].length || grid[row][column] < distance){
            return;
        }

        grid[row][column]=distance;

        dfs(grid,row+1,column,distance+1);
        dfs(grid,row-1,column,distance+1);
        dfs(grid,row,column+1,distance+1);
        dfs(grid,row,column-1,distance+1);
        
    }
}
