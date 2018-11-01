public class SnakeSequence{
    
    void maxsequence(int [][]matrix){
        int[][]dp=new int[matrix.length][matrix[0].length];
        int[] x_moves={1,0};
        int[] y_moves={0,1};
        matrix[0][0]=1;
        for(int i=1;i<matrix.length;i++){
            if(Math.abs(matrix[i-1][0]-matrix[i][0])==1){
                dp[i][0]=dp[i-1][0]+1;
            }
            else{
                dp[i][0]=1;
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            if(Math.abs(matrix[0][i-1]-matrix[0][i])==1){
                dp[0][i]=dp[0][i-1]+1;
            }
            else{
                dp[0][i]=1;
            }
        }int max=0;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                //bottom up
                if(Math.abs(matrix[i][j-1]-matrix[i][j])==1&&Math.abs(matrix[i-1][j]-matrix[i][j])==1){
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+1;
                    
                }
                else if(Math.abs(matrix[i][j-1]-matrix[i][j])==1){
                    
                    dp[i][j]=dp[i][j-1]+1;
                    
                }
                else if(Math.abs(matrix[i-1][j]-matrix[i][j])==1){
                    dp[i][j]=dp[i-1][j]+1;
                }
                else{
                    dp[i][j]=1;
                }
                if(dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        System.out.println(max);
    }

     public static void main(String []args){
         SnakeSequence ss=new SnakeSequence();
         int mat[][] = 
    { 
        {9, 6, 5, 2}, 
        {8, 7, 6, 5}, 
        {7, 3, 1, 6}, 
        {1, 1, 1, 7}, 
    };
        //System.out.println("Hello World");
        ss.maxsequence(mat);
     }
}
