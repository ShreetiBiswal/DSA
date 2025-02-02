package BinarySearch;

public class PeakElement {

    public static void main(String[] args) {


    }

    public int findInMountainArray(int target, int[] mountainArr) {

        int peak=findPeakElement(mountainArr);

        int firstAns=binarySearch(mountainArr,target,0,peak);

        if(firstAns!=-1) return firstAns;

        int lastAns=binarySearchRev(mountainArr,target,peak,mountainArr.length-1);

        return lastAns;

    }


    public int binarySearch(int[] nums, int target, int s, int e) {

        while (s <= e) {
            int m = s + (e - s) / 2;
            int el=nums[m];
            if(el==target) return m;
            else if(el>target) e=m-1;
            else s=m+1;
        }
        return -1;
    }

    public int binarySearchRev(int[] nums, int target, int s, int e) {

        while (s <= e) {
            int m = s + (e - s) / 2;
            int el=nums[m];
            if(el==target) return m;
            else if(el<target) e=m-1;
            else s=m+1;
        }
        return -1;
    }

    public static int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<e){
            int m=s+(e-s)/2;

            if(nums[m]<nums[m+1])s=m+1;
            else if(nums[m]>nums[m+1])e=m;
        }
        return s;
    }
}
