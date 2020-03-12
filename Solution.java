package maxCandies;

public class Solution {
	public int candy(int[] ratings) {
        //Edge case
        
        if(ratings.length == 0 || ratings==null)
        {
            return 0;
        }
        
        int n = ratings.length;
        
        int[] candies = new int[n]; //Array to store the candies
        
        //Fill all the positions with 1 
        
        for(int i=0;i<n;i++)
        {
            candies[i] = 1;
        }
        
    //Forward pass
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
                candies[i]+=1;
        }
        for(int i=0;i<n;i++)
        {
        	System.out.println("Candies after forward pass" +candies[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
        }
        
        for(int i=0;i<n;i++)
        {
        	System.out.println("Candies after backward pass" +candies[i]);
        }
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum+=candies[i];
        }
       return sum; 
    }
	public static void main(String[] args) {
		Solution obj =  new Solution();
		int[] ratings = {1,2,87,87,87,2,1};
		  
		    System.out.println(obj.candy(ratings));
	}

}