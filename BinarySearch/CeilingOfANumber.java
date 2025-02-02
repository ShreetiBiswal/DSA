package BinarySearch;

public class CeilingOfANumber {

    public static void main(String[] args) {

        int[]arr={-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        System.out.println(Ceiling(arr,17));
        System.out.println(Floor(arr,21));
    }

    static int Ceiling(int[]arr,int target){
        if(target>arr[arr.length-1])return  -1;

        int s=0,e=arr.length-1;
        while(s<=e){
            int m=s+(e-s)/2;

            if(arr[m]==target){
                return m;
            } else if (arr[m]>target) {
                e=m-1;
            }else{
                s=m+1;
            }

        }
        return s;
    }
    static char nextGreatestLetter(char[]letters,char target){
        if(target>=letters[letters.length-1])return  letters[0];

        int s=0,e=letters.length-1;
        while(s<=e){
            int m=s+(e-s)/2;

            if(letters[m]==target){
                if(letters[m+1]==target){
                    s=m+1;
                }else{
                    return letters[m+1];
                }
            } else if (letters[m]>target) {
                e=m-1;
            }else{
                s=m+1;
            }

        }
        return letters[s];
    }

    static int Floor(int[]arr,int target){

        if(target<arr[0])return -1;
        int s=0,e=arr.length-1;
        while(s<=e){
            int m=s+(e-s)/2;

            if(arr[m]==target){
                return m;
            } else if (arr[m]>target) {
                e=m-1;
            }else{
                s=m+1;
            }

        }

        return e;
    }
}


