package Algorithms;



import java.util.*;
class Graph{
    int V;
    LinkedList<Integer> []Adj;
    int []distance;
    int []pred;
    static int t=0;


    Graph(int V)
    {
        this.V=V;
        LinkedList<Integer> []Adj=new LinkedList[V+1];
        this.Adj=Adj;
        distance=new int[V+1];
        pred=new int[V+1];

        for(int i=0;i<Adj.length;i++)
        {
            Adj[i]=new LinkedList();
        }
    }

    void add_edge(int a,int b)
    {
        Adj[a].add(b);
        Adj[b].add(a);
    }

    int degree(int a)
    {
        return Adj[a].size();
    }

    void BFS(int S)
    {
        char []color=new char[V+1];

        for(int i=0;i<=V;i++) {
            distance[i]=-1;
        }
        for(int i=0;i<=V;i++) {
            pred[i]=-1;
        }
        for(int i=0;i<=V;i++) {
            color[i]='W';
        }

        distance[S]=0;

        LinkedList<Integer> Q=new LinkedList();
        Q.add(S);

        while(!Q.isEmpty())
        {
            int u=Q.poll();
            color[u]='G';

            for(int i=0;i<Adj[u].size();i++) {
                int v=Adj[u].get(i);
                if(color[v]=='W') {
                    Q.add(v);
                    color[v]='G';
                    distance[v]=distance[u]+1;
                    pred[v]=u;
                }
            }
            color[u]='B';

        }
        System.out.println("Distance from source:");
        for(int i=1;i<=V;i++) {

            System.out.println("Vertex "+i+":"+distance[i]+" ");
        }
        System.out.println();
        System.out.println("Predecessor");
        for(int i=1;i<=V;i++) {
            System.out.println(i+" Pred:"+pred[i]);
        }
    }

    void printPath(int s,int t) {
        if(t==s) {
            System.out.print(s+"-->");
            return;
        }
        printPath(s,pred[t]);
        System.out.print(t+"-->");
    }

    void DFS(int s){
        int[]startTime=new int[V+1];
        int[]finishTime=new int[V+1];
        char []color=new char[V+1];
        for(int i=0;i<=V;i++) {
            pred[i]=-1;
        }
        for(int i=1;i<=V;i++) {
            color[i]='W';
        }

        DFS_Visit(s,startTime,finishTime,color);

        for(int i=1;i<=V;i++){
            System.out.println(i+", Start:"+startTime[i]+",Finish:"+finishTime[i]);
        }
        System.out.println("Predecessor");
        for(int i=1;i<=V;i++) {
            System.out.println(i+" Pred:"+pred[i]);
        }
        t=0;
    }

     void DFS_Visit(int v, int[] startTime, int[] finishTime, char[] color) {

        if(color[v]=='B'){
            return;
        }


            color[v]='G';
            t++;
            startTime[v]=t;
            for(int i=0;i<Adj[v].size();i++){
                int u=Adj[v].get(i);
                if(color[u]=='W'){
                    pred[u]=v;
                    DFS_Visit(u,startTime,finishTime,color);
                }
            }
            color[v]='B';
            t++;
            finishTime[v]=t;

    }


}





public class Graph_Traversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter no of vertices:");
        int v=sc.nextInt();
        System.out.println("Enter no of edges:");
        int e=sc.nextInt();
        Graph G=new Graph(v);

        for(int i=1;i<=e;i++) {
            System.out.println("Enter edge no "+i);
            G.add_edge(sc.nextInt(), sc.nextInt());
        }
        System.out.println("BFS:---");
        G.BFS(1);
        for(int i=1;i<=v;i++){
            G.printPath(1,i);
            System.out.println();
        }
        System.out.println();
        System.out.println("DFS:---");
        G.DFS(1);
        for(int i=1;i<=v;i++){
            G.printPath(1,i);
            System.out.println();
        }


    }

}

