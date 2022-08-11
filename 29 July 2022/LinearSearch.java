public class LinearSearch {
    static int linearSearch(int arr[],int ele){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==ele){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{12,25,32,35,65,95};
        System.out.println("Index : "+ linearSearch(arr, 95));

    }
}
