class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int results = 0;
        for (int i=0;i<n;i++){
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        for (int i=0;i<n;i++){
            if(!visited[i]){
                bfsForCount(adjacencyList,visited,i);
                results++;
            }
        }
        return results;
    }

    private void bfsForCount(List<List<Integer>> adjacencyList,boolean[] visited,int node){
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(node);
        visited[node]=true;
        while (!bfsQueue.isEmpty()){
            int newNode = bfsQueue.poll();
            for (int i:adjacencyList.get(newNode)){
                if(!visited[i]){
                    visited[i]=true;
                    bfsQueue.add(i);
                }
            }
        }
    }
}
