package BinarySearch;

public class RoatedBinarySearch {

    public static void main(String[] args) {
        int[]nums={3,5,1};
        System.out.println(search(nums,3));
    }

    public static int search(int[] nums, int target) {

        int pivot=findPivot(nums);

        if(pivot==-1){
            return binarySearch(nums,target,0,nums.length-1);
        }

        if(nums[pivot]==target){
            return  pivot;
        }else if(nums[pivot]>target){
            return binarySearch(nums,target,pivot+1,nums.length-1);
        }else {
            return binarySearch(nums,target,0,pivot-1);
        }
    }

    static  int noOfRotated(int[]arr){
        int p=findPivot(arr);

        return p+1;
    }

    static  int findPivot(int[]arr){
        int s=0;
        int e=arr.length-1;

        while (s<=e){

            int m=s+(e-s)/2;

            if(m<e && arr[m]>arr[m+1])return  m;

            if(m>s && arr[m]<arr[m-1])return m-1;

            if(arr[m]<=arr[s]) e=m-1;
            else s=m+1;
        }

        return -1;
    }

    public static int  binarySearch(int[] nums, int target, int s, int e) {

        while (s <= e) {
            int m = s + (e - s) / 2;
            int el=nums[m];
            if(el==target) return m;
            else if(el>target) e=m-1;
            else s=m+1;
        }
        return -1;
    }
}
