class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int[] prerequisite: prerequisites){
            int course=prerequisite[0];
            int prereq=prerequisite[1];
            adjacencyList.get(prereq).add(course);
        }

        int[] state = new int[numCourses];

        for(int course=0;course<numCourses;course++){
            if(hasCycle(course,adjacencyList,state)){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course,List<List<Integer>> adjacencyList,int[] state){
        if(state[course]==1){
            return true;
        }

        if(state[course]==2){
            return false;
        }

        state[course]=1;

        for(int newCourse: adjacencyList.get(course)){
            if(hasCycle(newCourse,adjacencyList,state)){
                return true;
            }
        }
        
        state[course]=2;
        return false;

    }
}
