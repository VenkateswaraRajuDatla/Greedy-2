//time o(n)
//space o(n)
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int Totalcandies = 0;
        int len = ratings.length;
        int[] candies = new int[len];
        
        for(int i=0; i<len; i++) {
            candies[i] = 1;
        }
        
        //left to right
        for(int i=1; i<len; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        //right to left
        for(int i=len-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        
        for(int i=0; i<len; i++) {
            Totalcandies += candies[i];
        }
        return Totalcandies;
    }
}