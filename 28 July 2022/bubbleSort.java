import java.util.Scanner;

public class bubbleSort {
    static void sort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n;i++){   // n + 1
            for(int j=0;j<n;j++){   // n (n + 1)
                if(arr[i]<arr[j]){  //n * n
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j]= tmp;
                }
            }
        }
    }
    public static void main(String args[]){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
        sc.close();
    }
}
