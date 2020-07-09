//time o(n)
//space o(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
            return 0;
        int tasksLen = tasks.length;
        int maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(char ch: tasks) {
            map.put(ch, map.getOrDefault(ch, 0) +1);
            maxFreq = Math.max(maxFreq, map.get(ch));
        }
        
        for(char c: map.keySet()) {
            if(map.get(c) == maxFreq) {
                maxCount++;
            }
        }
        
        int partitions = maxFreq-1;
        int emptySpots = partitions * (n-maxCount+1);
        int pendingTasks = tasksLen - (maxFreq*maxCount);
        int spotsLeft = Math.max(0, emptySpots - pendingTasks);
        
        int time = tasksLen + spotsLeft;
        
        return time;
    }
}