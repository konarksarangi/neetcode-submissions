class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int directions[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        Queue<int[]> bfsQueue = new LinkedList<>();

        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j] ==0){
                    bfsQueue.add(new int[]{i,j});
                }
            }
        }

        while (!bfsQueue.isEmpty()){
            int[] cell = bfsQueue.poll();
            int row=cell[0];
            int column=cell[1];

            for (int[] direction:directions){
                int newRow = row+direction[0];
                int newColumn = column+direction[1];

                if(newRow<0 || newColumn<0 || newRow >=rows || newColumn >=columns || grid[newRow][newColumn] != 2147483647){
                    continue;
                }

                grid[newRow][newColumn] = grid[row][column]+1;
                bfsQueue.add(new int[]{newRow,newColumn});
            }
        }
    }
}
