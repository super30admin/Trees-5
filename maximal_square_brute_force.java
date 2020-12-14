// Time Complexity : O((m*n)^2), where m is the number of rows and n is the number of columns in the matrix
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

//Three liner approach of your code in plain english
//1. Iterate of the entire matrix, and while at each cell do the following,
        //a. check if the bottom diagonal cell is 1
        //b. If yes, check if all the cells vertically UP till the "i" (cell we are checking the square for) are 1
        //c. If yes, check if all the cells horizontally LEFT till the "j" (cell we are checking the square for) are 1
        //d. If yes, increase the count
//2. If any one of the above fails, break and go the next cell and do all the above for that cell
//3. For each iteration keep updating the max with the highest value of the count and return max*max(area of the maximum square)

// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        //number of rows and columns in the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        
        //for each 1 in the matrix traverse over the entire matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //reset the count for every new 1
                int count = 0;
                if(matrix[i][j] == '1'){
                    count++;
                    int row = i+1;
                    int col = j+1;
                    
                    //check if the diagonal cell is also a 1
                    while(row<m && col<n && matrix[row][col] == '1'){
                        //2 flags to decide if it is a valid square
                        boolean up = true;
                        boolean left = true;
                        //then check if all the cells vertically UP till the i is also 1
                        for(int k=row; k>=i; k--){
                            if(matrix[k][col] != '1'){
                                up = false;
                                break;
                            }
                        }
                        //then check if all the cells horizonatlly LEFT till the j is also 1
                        for(int k=col; k>=j; k--){
                            if(matrix[row][k] != '1'){
                                left = false;
                                break;
                            }
                        }
                        //if any flag becomes false break
                        if(!up || !left) break;
                        //else increase the count
                        count++;
                        //go 1 diagonal down
                        row++; col++;
                    }
                    //update the max
                    max = Math.max(max, count);
                }
            }
        }
        //return area of the maximum square
        return max*max;
    }
}