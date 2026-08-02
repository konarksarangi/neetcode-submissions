class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int result=0;

        for (int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        boolean [] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(adjacencyList,visited,i);
                result++;
            }
        }
        return result;
    }

    private void bfs(List<List<Integer>> adjacencyList, boolean [] visited, int vertex){
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(vertex);
        int length=0;
        visited[vertex]=true;

        while(!bfsQueue.isEmpty()){
            int node = bfsQueue.poll();
            for (int i:adjacencyList.get(node)){
                if(!visited[i]){
                    visited[i]=true;
                    bfsQueue.add(i);
                }
            }
        }

    }
}
