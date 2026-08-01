class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for (int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return dfs(0,-1,graph,hasApple);
    }

    private int dfs(int node, int parent, List<List<Integer>> graph, List<Boolean> hasApple){

        int totalTime = 0;

        for(int child:graph.get(node)){
            if(child == parent){
                continue;
            }

            int childTime = dfs(child,node,graph,hasApple);

            if(childTime > 0 || hasApple.get(child)){
                totalTime+=childTime+2;
            }
        }
        return totalTime;

    }
}