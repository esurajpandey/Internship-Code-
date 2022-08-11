import java.util.Scanner;
public class AdjacencyMatrix{
    private int v;
    private int e;
    private int[][] graph;

    public AdjacencyMatrix(int n){
        this.v = n;
        this.e = 0;
        this.graph = new int[n][n];
    }

    public void addEdge(int u,int v){
        graph[u][v] = 1;
        graph[v][u] = 1;
        e++;
    }
    public void print(){
        System.out.print(v + " vertices "+ e +" edges \n");
        for(int i=0;i<v;i++){
            System.out.print(i +" : ");
            for(int x:graph[i]){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices:");
        int v = sc.nextInt();
        AdjacencyMatrix g = new AdjacencyMatrix(v);
        System.out.print("\nEnter number of edges: ");
        int e = sc.nextInt();

        for(int i=0;i<e;i++){
            System.out.print("Enter the source: ");
            int x = sc.nextInt();
            System.out.print("Enter the destination: ");
            int y = sc.nextInt();
            g.addEdge(x, y);
        }
        g.print();
        sc.close();
    }
}