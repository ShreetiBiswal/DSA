package Algorithms;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

class vertex{
    int name;
    int pred;
    int dist;
    ArrayList<edge> AdjList;

    vertex(int name){
        this.name=name;
        this.pred=-1;
        this.dist=999;
        AdjList=new ArrayList<>();
    }

    void addEdge(edge e){
        AdjList.add(e);
    }
    void setPred(int pred){
        this.pred=pred;
    }
    void setDist(int dist){
        this.dist=dist;
    }

    int getName(){
        return name;
    }
    int getDist(){
        return dist;
    }

    public String toString(){
        return name+",pred:"+pred+",dist:"+dist;
    }
}

class ShortestPathGraph{
    int V;
    int E;
    vertex []allVertices;

    ShortestPathGraph(int V,int E){
        this.V=V;
        this.E=E;
        this.allVertices=new vertex[V];

        for(int i=0;i<V;i++){
            allVertices[i]=new vertex(i);
        }
    }

    void createGraph(){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<E;i++){
            System.out.println("Enter edge");
            int u=sc.nextInt();
            int v= sc.nextInt();
            System.out.println("Enter weight:");
            int w= sc.nextInt();
            edge e=new edge(u,v,w);
            allVertices[u].addEdge(e);
            allVertices[v].addEdge(e);
        }
        sc.close();
    }

    void Dikjastra(int s){

        allVertices[s].setDist(0);//Setting distance of source as 0

        PriorityQueue<vertex> minHeap=new PriorityQueue<>((v1,v2)->((v1.getDist()-v2.getDist())));
        for(int i=0;i<V;i++){
            minHeap.add(allVertices[i]);
        }

        while (!minHeap.isEmpty()){
            vertex currVertex=minHeap.poll();
            for(edge e:currVertex.AdjList){
                int v=e.getEnd(currVertex.getName());
                if((currVertex.getDist()+e.weight())<allVertices[v].getDist()){//relaxing edge
                    minHeap.remove(allVertices[v]);
                    allVertices[v].setDist(currVertex.getDist()+e.weight());
                    allVertices[v].setPred(currVertex.getName());
                    minHeap.add(allVertices[v]);
                }
            }
        }

        for(int i=0;i<V;i++){
            System.out.println(allVertices[i]);
        }

    }
}
public class ShortestPath {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of vertices:");
        int v= sc.nextInt();
        System.out.println("Enter no of edges:");
        int e=sc.nextInt();
        ShortestPathGraph G=new ShortestPathGraph(v,e);
        G.createGraph();
        G.Dikjastra(0);
    }

}
