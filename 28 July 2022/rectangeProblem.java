import java.util.*;
public class rectangeProblem{
    public static int[] previousSmaller(int a[]){
       int ps[] = new int[a.length];
        Stack<Integer>s = new Stack<Integer>();
        
       for(int i=0;i<a.length;i++){
           while(!s.isEmpty() && a[s.peek()] >=a[i]){
               s.pop();
           }
           if(s.isEmpty()){
               ps[i] = -1;
           }else{
               ps[i] = s.peek();
           }
           s.push(i);
       }
       return ps;
    }
    
    public static int[] nextSmaller(int a[]){
        int ns[] = new int[a.length];
        Stack<Integer>s = new Stack<Integer>();
        for(int i=a.length-1; i>=0; i--){
            while(!s.isEmpty() && a[s.peek()]>=a[i]){
               s.pop();
           }
           if(s.isEmpty()){
               ns[i] = -1;
           }else{
               ns[i] = s.peek();
           }
           s.push(i);
        }
        return ns;
    }
    //max area of histogram
    public static int getMaxArea(int [] arr){
        int n = arr.length;
        int [] right = nextSmaller(arr);
        int [] left = previousSmaller(arr);
        
        int maxarea = 0;
        
        for (int i = 0; i < n; i++) {
            int height = arr[i];
                if (right[i] == -1) {
                    right[i] = n;
                }
            int breadth = right[i] - left[i] - 1;
            maxarea = Math.max(maxarea,height * breadth);
        }
        return maxarea;
    }

    static int maxAreaByOnes(int a[][]){
        int curRow[] = a[0];
        int res =  getMaxArea(a[0]);//for 0th curRow
        
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j] == 1){
                  curRow[j] = curRow[j] + 1;
                }else{
                    curRow[j] = 0;
                }
               
            }
            int ans = getMaxArea(curRow);//find area till this row
            res = Math.max(res,ans);
        }
        return res;
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("\nEnter length of rows: ");
	    int r = sc.nextInt();
	    
	    System.out.print("\nEnter length of colums: ");
	    int c = sc.nextInt();
		int arr[][] = new int[r][c];//{{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1,1},{1,0,0,1,0}};
		//reading from user
		for(int i=0;i<r;i++){
		    for(int j=0;j<c;j++){
		        arr[i][j] = sc.nextInt();
		    }
		}
        int ar = maxAreaByOnes(arr);
        System.out.print("Maximum area formed by 1's: "+ ar);
	}
}


