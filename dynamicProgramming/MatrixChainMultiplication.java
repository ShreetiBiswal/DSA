package dynamicProgramming;

public class MatrixChainMultiplication {

    public static void minNoOfMultiplications(int[]p) {
        int n = p.length - 1;
        int[][] M = new int[n][n];
        int[][]kValues=new int[n][n];
        for (int i = 0; i < n; i++) {
            M[i][i] = 0;
        }

        for (int j = 1; j < n; j++) {
            int c = j, i = 0;
            while ( c < n) {
                int min=Integer.MAX_VALUE;
                int kV=0;
                for(int k=i;k<c;k++){
                    int noOfMul=M[i][k]+M[k+1][c]+p[i]*p[k+1]*p[c+1];
                    if(min>noOfMul){
                        min=noOfMul;
                        kV=k;
                    }
                }
                M[i][c]=min;
                kValues[i][c]=kV;
                i++;
                c++;
            }
        }
        System.out.println("Min no of multiplications:"+M[0][n-1]);
        System.out.println("Order of multiplication:-");
        System.out.println(printOrder(kValues,0,n-1));

    }

    public static String  printOrder(int[][]KValues,int i,int j){
        if( i>j||i==KValues.length || j== KValues.length){
            return "";
        }
        if(i==j){
            return "M"+(i+1);
        }
        int k=KValues[i][j];
        return "("+printOrder(KValues,i,k)+")*("+printOrder(KValues,k+1,j)+")";
    }
    public static void main(String[]args) {

        int[]p={30,35,15,5,10,20,25};
       minNoOfMultiplications(p);
    }
}
