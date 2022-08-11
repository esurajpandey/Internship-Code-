import java.util.Scanner;
//best way to store 
public class weightedAdjacencyMatrix{
    private int v;
    private int e;
    private int[][] graph;
    public weightedAdjacencyMatrix(int n){
        this.v = n;
        this.e = 0;
        this.graph = new int[n+1][n+1];
    }
    
    public void addEdge(int u,int v,int weight,boolean undirected){
        graph[u][v] = weight;
        if(undirected)
            graph[v][u] = weight;
        e++;
    }
    public void print(){
        System.out.print(v + " vertices "+ e +" edges \n");
        for(int i=1;i<=v;i++){
            System.out.print(i +" : ");
            for(int x=1;x<graph[i].length;x++){
                System.out.print(graph[i][x]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices:");
        int v = sc.nextInt();
        weightedAdjacencyMatrix g = new weightedAdjacencyMatrix(v);
        System.out.print("\nEnter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter data [source destination weight]eg[1 2 23]:");
        for(int i=1;i<=e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int weight = sc.nextInt();
            g.addEdge(x, y,weight,false);
        }
        g.print();
        sc.close();
    }
}