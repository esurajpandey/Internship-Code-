import java.util.*;
public class AdjacencyList {
    int v;
    ArrayList<ArrayList<Integer>> container;
    AdjacencyList(int v){
        this.v = v;
        container = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++){
            container.add(new ArrayList<Integer>());
        }

    }

    public void addEdge(int x,int y,boolean undirected){
        container.get(x).add(y);
        if(undirected)//if graph is undirected
            container.get(y).add(x);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number of vertices: ");
        int v = sc.nextInt();
        AdjacencyList g = new AdjacencyList(v);
        System.out.print("\nEnter number of Edges: ");
        int e = sc.nextInt();
        //reading input from user
        for(int i=0;i<e;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            g.addEdge(start, end,false);
        }
        g.print();
        sc.close();
    }

    public void print() {
        for(int i=0;i<container.size();i++){
            System.out.print(i);
            for(int j=0;j<container.get(i).size();j++){
                System.out.print(" -> "+container.get(i).get(j));
            }
            System.out.println();
        }
    }

}
