class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;

        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxArea=Math.max(maxArea,dfs(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int column){
        if(row<0 || column <0 || row>=grid.length || column>=grid[0].length || grid[row][column]==0){
            return 0;
        }

        grid[row][column] = 0;
        int areaCount=1;
        areaCount+=dfs(grid,row+1,column);
        areaCount+=dfs(grid,row-1,column);
        areaCount+=dfs(grid,row,column+1);
        areaCount+=dfs(grid,row,column-1);

        return areaCount;
    }
}
