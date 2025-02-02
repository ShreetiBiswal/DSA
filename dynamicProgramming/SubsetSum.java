package dynamicProgramming;
import  java.util.*;
public class SubsetSum {

    public static void main(String[] args) {

        int[]arr={1,2,7,13,5,2};
        System.out.println("Does the array:"+Arrays.toString(arr)+" contain a subset of sum=22?"+"\nAns:"+subsetSum(arr,22));
    }

    static boolean subsetSum(int[]arr,int sum){

        int n=arr.length;
        boolean [][] Dp=new boolean[n+1][sum+1];

        //Initialization
        for(int i=0;i<n+1;i++){
            Dp[i][0]=true;
        }
        for(int i=1;i<sum+1;i++){
            Dp[0][i]=false;
        }

        //Table filling
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(j<arr[i-1]){
                    Dp[i][j]=Dp[i-1][j];
                }else{
                    Dp[i][j]=Dp[i-1][j]||Dp[i-1][j-arr[i-1]];
                }
            }
        }

        return Dp[n][sum];
    }

}

/*Output:-
 Does the array:[1, 2, 7, 13, 5, 2] contain a subset of sum=22?
Ans:true
 */