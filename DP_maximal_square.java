// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns in the matrix
// Space Complexity :  O(m*n), where m is the number of rows and n is the number of columns in the matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code in plain English
//1. Create a dp array with 1 extra row and column than the matrix (to avoid the boundry condition checks)
//2. Iterate over the matrix, and if the cell is 1, do the following
        //a. take the minimum between the up cell, upper left cell and left cell of the dp array
        //b. add 1 to this minimum value, which becomes the value of the cell dp[i+1][j+1]
        //c. update the max value
//3. In the end return max*max (area of the maximal square)

// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //create a DP array, with 1 extra row and column than than the matrix
        int[][] dp = new int[m+1][n+1];
        
        //variable to maintian the maximal square length
        int max = 0;
        
        //iterate over the matrix to fill out the dp array
        for(int i=0; i<m; i++){
           for(int j=0; j<n; j++){
               //check if the cell has a value 1
               if(matrix[i][j] == '1'){
                   //take the minimum of the 3 sides in the dp array (up, upper left, left)
                   int min = Math.min(dp[i][j+1], Math.min(dp[i][j], dp[i+1][j]));
                   //the value of dp[i][j] becomes min + 1
                   dp[i+1][j+1] = min + 1;
                   //update max
                   max = Math.max(max, dp[i+1][j+1]);
               }
           } 
        }
        //return maximal square area
        return max*max;
    }
}