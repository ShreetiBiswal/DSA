package BinarySearch;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[]arr={7,2,5,10,8};

        System.out.println(splitArrayLargestSum(arr,2));
    }


    static int splitArrayLargestSum(int[]nums,int m){

        int s=0;
        int e=0;

        for(int num:nums){
            s=Math.max(s,num);
            e+=num;
        }

        while (s<e){

            int mid=s+(e-s)/2;
            int sum=0;
            int pieces=1;

            for(int num:nums){
                if(sum+num <=mid){
                    sum+=num;
                }else {
                    sum=num;
                    pieces++;
                }
            }

            if(pieces>m){
                s=mid+1;
            }else {
                e=mid;
            }
        }

        return  e;
    }
}


