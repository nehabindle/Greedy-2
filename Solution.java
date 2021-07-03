/*Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 */


package TaskScheduler;

import java.util.HashMap;



class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
        {
            return 0;
        }
        
        int maxCount = 0;
        int maxFreq = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<tasks.length; i++)
        {
            if(!map.containsKey(tasks[i]))
            {
                map.put(tasks[i],0);
            }
            
            int count = map.get(tasks[i])+1;
            map.put(tasks[i],count);
            maxFreq = Math.max(maxFreq, count);
        }
        
        for(int val: map.values())
        {
            if(val==maxFreq)
                maxCount++;
        }
        
        int partitions = maxFreq-1;
        int empty = (n-(maxCount-1))*partitions;
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0,empty-pendingTasks);
        return tasks.length+idle;
    }
    
    public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		Solution obj = new Solution();
		System.out.println(obj.leastInterval(tasks,2));
		
	
	}
}
