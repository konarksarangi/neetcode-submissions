class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int result = 0;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid,int row, int column){
        if(row<0 || column<0 || row>= grid.length || column >=grid[0].length || grid[row][column] =='0'){
            return;
        }

        grid[row][column]='0';
        
        dfs(grid,row+1,column);
        dfs(grid,row-1,column);
        dfs(grid,row,column+1);
        dfs(grid,row,column-1);
        
    }
}
