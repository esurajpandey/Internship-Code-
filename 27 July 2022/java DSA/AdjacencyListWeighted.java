import java.util.*;


public class AdjacencyListWeighted {
    //it will store the connected vertex with edge weight
    class Pair{
        int end;
        int weight;
        Pair(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
        @Override
        public String toString(){
            return "with  "+end+" edge weight "+weight;
        }
    }
    int v;
    ArrayList<ArrayList<Pair>> container;
    AdjacencyListWeighted(int v){
        this.v = v;
        container = new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<v;i++){
            container.add(new ArrayList<Pair>());
        }

    }


    public void addEdge(int x,int y,int weight,boolean undirected){
        container.get(x).add(new Pair(y,weight));
        if(undirected)//if graph is undirected
            container.get(y).add(new Pair(x, weight));
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number of vertices: ");
        int v = sc.nextInt();
        AdjacencyListWeighted g = new AdjacencyListWeighted(v);
        System.out.print("\nEnter number of Edges: ");
        int e = sc.nextInt();
        //reading input from user
        for(int i=0;i<e;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            g.addEdge(start, end,weight,true);
        }
        g.print();
        sc.close();
    }
}

