package Algorithms;
import java.util.*;

class edge{
    int u,v,w;
    edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }

    int getEnd(int x){
        if(x==u){
            return v;
        }else{
            return u;
        }
    }
    int weight() {
        return this.w;
    }

    void showEdge() {
        System.out.println("u:"+u+",v:"+v);
    }
}

class MstGraph{

    int V,E;

    ArrayList<edge>[]AdjList;
    ArrayList<edge> AllEdge;

    MstGraph(int V,int E){
        this.V=V;
        this.E=E;
        ArrayList<edge>[]AdjList=new ArrayList[V+1];
        for(int i=0;i<AdjList.length;i++) {
            AdjList[i]=new ArrayList();
        }
        this.AdjList=AdjList;
        AllEdge=new ArrayList();
    }

    void addEdge(int u,int v,int w) {
        edge e=new edge(u,v,w);
        AdjList[u].add(e);
        AdjList[v].add(e);
        AllEdge.add(e);
    }

    Set<Integer>[] makeSet() {
        Set<Integer>[] set=new HashSet[V+1];
        for(int i=1;i<=V;i++) {
            set[i]=new HashSet();
            set[i].add(i);
        }

        return set;
    }

    void sortEdge() {
        Comparator<edge> wComp=(edge e1,edge e2)->(e1.weight()-e2.weight());
        this.AllEdge.sort(wComp);
    }
    boolean findSet(int u,int v,Set<Integer>[] set) {
        int i,j;
        for(i=1;i<=V;i++) {
            if(set[i].contains(u)) {
                break;
            }
        }
        for(j=1;j<=V;j++) {
            if(set[j].contains(v)) {
                break;
            }
        }

        return i==j;
    }
    ArrayList<edge> Krushkal() {
        ArrayList<edge> M=new ArrayList<>();

        this.sortEdge();
        Set<Integer>[] set=this.makeSet();
        for(int i=0;i<AllEdge.size();i++) {
            edge currEdge=AllEdge.get(i);
            int u=currEdge.u;
            int v=currEdge.v;
            int k,j;
            for(k=1;k<=V;k++) {
                if(set[k].contains(u)) {
                    break;
                }
            }
            for(j=1;j<=V;j++) {
                if(set[j].contains(v)) {
                    break;
                }
            }

            if(k!=j) {
                M.add(currEdge);
                set[k].addAll(set[j]);
                set[j].clear();
            }
        }
        return M;
    }

    void showMST_Kruskal(ArrayList<edge> M){
        int w=0;
        System.out.println("The MST contains the following edges:");
        for(int i=0;i<M.size();i++) {
            M.get(i).showEdge();
            w+=M.get(i).weight();
        }
        System.out.println("Weight of mst:"+w);
    }
}
public class MinimumSpanningTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of vertices and edges");
        int V=sc.nextInt(),E=sc.nextInt();
        MstGraph G=new MstGraph(V,E);
        for(int i=1;i<=E;i++) {
            System.out.println("Enter start,end,and weight");
            G.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());

        }
        ArrayList<edge> M=G.Krushkal();
        G.showMST_Kruskal(M);
    }

}
