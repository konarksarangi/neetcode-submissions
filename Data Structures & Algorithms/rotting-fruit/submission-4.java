class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int fresh=0;
        int minutes=0;

        Queue<int[]> bfsQueue = new LinkedList<>();

        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(grid[r][c] == 2){
                    bfsQueue.add(new int[]{r,c});
                }else if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }

        if(fresh==0){
            return 0;
        }

        int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!bfsQueue.isEmpty() && fresh>0){
            int size=bfsQueue.size();

            for(int i=0;i<size;i++){
                int [] cell = bfsQueue.poll();
                int row = cell[0];
                int column = cell[1];

                for (int[] dir : directions){
                    int newRow = row+dir[0];
                    int newColumn = column+dir[1];

                    if(newRow<0 || newColumn<0 || newRow>=rows || newColumn>=columns || grid[newRow][newColumn]!=1){
                        continue;
                    }
                    grid[newRow][newColumn]=2;
                    fresh--;
                    bfsQueue.add(new int[]{newRow,newColumn});

                }
            }
            minutes++;
        }
        return fresh==0?minutes:-1;
    }
}
