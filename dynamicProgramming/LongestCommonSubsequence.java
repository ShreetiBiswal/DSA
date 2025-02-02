package dynamicProgramming;

public class LongestCommonSubsequence {


    public static String longestCommonSubsequenceRecursive(String x,String y,String subSeq){
        int n=x.length(),m=y.length();
        if(n==0 || m==0){
           return subSeq;
        }

        if(x.charAt(n-1)==y.charAt(m-1)){
           return longestCommonSubsequenceRecursive(x.substring(0,n-1),y.substring(0,m-1),x.charAt(n-1)+subSeq);
        }else {
            String subSeqL=longestCommonSubsequenceRecursive(x,y.substring(0,m-1),subSeq);
            String subSeqR=longestCommonSubsequenceRecursive(x.substring(0,n-1),y,subSeq);

            if(subSeqL.length()>subSeqR.length()){
                return subSeqL;
            }
            else {
                return subSeqR;
            }        }
    }

    public static void longestCommonSubstringDP(String x,String y){
        int n=x.length(),m=y.length();

        int [][]RTAB=new int[m+1][n+1];
        String [][]RTAB_String=new String[m+1][n+1];

        for(int i=0;i<m+1;i++){
            RTAB[i][0]=0;
            RTAB_String[i][0]="";
        }
        for(int i=0;i<n+1;i++){
            RTAB[0][i]=0;
            RTAB_String[0][i]="";
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(y.charAt(i-1)==x.charAt(j-1)){
                    RTAB[i][j]=RTAB[i-1][j-1]+1;
                    RTAB_String[i][j]=RTAB_String[i-1][j-1]+y.charAt(i-1);
                }
                else{
                    String subSeql=RTAB_String[i-1][j];
                    int l=RTAB[i-1][j];
                    String subSeqr=RTAB_String[i][j-1];
                    int r=RTAB[i][j-1];
                    RTAB_String[i][j]=l>r?subSeql:subSeqr;
                    RTAB[i][j]=l>r?l:r;
                }
            }
        }
        System.out.println("Length of longest substring:"+RTAB[m][n]);
        System.out.println("Longest substring:"+RTAB_String[m][n]);
    }

    public static void main(String[] args) {
        String subSeq=longestCommonSubsequenceRecursive("ABCBDAB","BDCABA","");
        System.out.println(subSeq);
        longestCommonSubstringDP("ABCBDAB","BDCABA");
    }
}
