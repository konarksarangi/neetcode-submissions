class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character,Integer> characterMap = new HashMap<>();
        int maxFrequency=0; //Max frequnecy value of the characters in the map 
        int maxFrequencyCounter=0; // How many character have the same frequency as the max frequency

        for (char c:tasks){
          characterMap.put(c,characterMap.getOrDefault(c,0)+1);
        }
        maxFrequency = Collections.max(characterMap.values());

        for (Integer i:characterMap.values()){
          if(i==maxFrequency){
            maxFrequencyCounter++;
          }
        }
        /*
          1. The number of complete gaps/blocks between the most frequent tasks is maxFrequency - 1.
          2. Each block must have a length of at least n + 1 (the task itself plus the n cooldown slots).
          3. After all blocks, we append the remaining instances of the most frequent tasks (maxFrequencyCounter)
        */
        int minCyclesByFormula = ((maxFrequency - 1) * (n + 1)) + maxFrequencyCounter;
        return Math.max(tasks.length, minCyclesByFormula);   
    }
}
