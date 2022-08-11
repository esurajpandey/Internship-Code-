public class mergeSort {
    static void mergesort(int arr[],int l,int r){
        if(l<r){
            int mid = l + (r-l)/2;
            mergesort(arr, l, mid);
            mergesort(arr, mid+1, r);
            merge(arr,l,mid,r);
        }
    }
    static void merge(int arr[],int l,int mid,int r){
        int n1 = mid - l + 1;
        int n2 = r -mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        
        int k = l;
        for(int i=0;i<n1;i++){
            left[i] = arr[k++];
        }
        k = mid+1;
        for(int i=0;i<n2;i++){
            right[i] = arr[k++];
        }

        int i=0,j=0;
        k = l;
        while(i<n1 && j<n2){
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(i<n1){
            arr[k++] = left[i++];
        }
        while(j<n2){
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{10,56,23,74,14,32};
        mergesort(arr,0,arr.length-1);
        for(int k:arr){
            System.out.print(k+" ");
        }
    }
}
