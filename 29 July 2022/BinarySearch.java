import java.util.*;
public class BinarySearch {
    static int binary(int arr[],int l,int r,int ele){
        if(l<=r){
            int mid =(l+r)/2;
            if(arr[mid] == ele){
                return mid;
            }
           

            if(arr[mid]>ele){
                return binary(arr, l, mid-1, ele);//left
            }
            System.out.println("l: "+l+" r :"+r +" mid: "+mid);
            return binary(arr, mid+1, r, ele);//right
            
        }
        return -1;
    }

    static int binWithOutSort(int arr[],int l,int r,int ele){
        if(l<r){
            int mid = (l+r)/2;
            System.out.println(mid);
            if(arr[mid] == ele){
                return mid;
            }
           
            binary(arr, l, mid-1, ele);
            binary(arr, mid+1, r, ele);
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{12,25,32,35,65,95};
        System.out.println("Index : "+ binary(arr, 0, arr.length-1, 95));

    }
}
