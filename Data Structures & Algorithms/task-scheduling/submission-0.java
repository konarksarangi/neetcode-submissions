class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character,Integer> characterCountMap = new HashMap<>();
        for (char t: tasks){
          characterCountMap.put(t,characterCountMap.getOrDefault(t, 0)+1);
        }

        int maxFreq = Collections.max(characterCountMap.values());
        int maxFreqCounter = 0;

        for (Integer value : characterCountMap.values()){
          if(value == maxFreq){
            maxFreqCounter++;
          }
        }

        int minCyclesByFormula = (maxFreq - 1) * (n + 1) + maxFreqCounter;

        return Math.max(tasks.length, minCyclesByFormula);
    }
}
