class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int count=0;
        int fresh=0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j] ==2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j] ==1){
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty() && fresh >0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cell = queue.poll();
                int row=cell[0];
                int column=cell[1];
                for(int[] direction:directions){
                    int newRow = row+direction[0];
                    int newColumn = column+direction[1];
                    if(newRow<0 || newColumn<0 || newRow>=rows || newColumn>=columns || grid[newRow][newColumn] !=1 ){
                        continue;
                    }
                    grid[newRow][newColumn] = 2;
                    fresh--;
                    queue.add(new int[]{newRow,newColumn});
                }
            }
            count++;
        }
        return fresh==0 ? count : -1;
    }
    
}
