package ex;

import java.util.LinkedList;
import java.util.Scanner;

public class Graph {
    private int v;
    private LinkedList<Integer> [] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for(int i=0; i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
    }
    public void modifyEdge(int v, int oldW, int newW){
        if(adj[v].contains(oldW)){
            adj[v].remove(Integer.valueOf(oldW));
            adj[v].add(newW);
        }
    }
    public void removeEdge(int v, int w){
        adj[v].remove(Integer.valueOf(w));
    }
    public void addVertex(){
        v++;
        LinkedList<Integer> [] newAdj = new LinkedList[v];
        System.arraycopy(adj,0,newAdj,0,adj.length);
        newAdj[v-1]=new LinkedList<>();
        adj = newAdj;
    }
    public void removeVertex(int v){
        for(int i=0;i<v;i++){
            adj[i].remove(Integer.valueOf(v));
        }
        LinkedList<Integer>[] newAdj = new LinkedList[v - 1];
        for(int i=0, j=0; i<v;i++){
            if(i != v){
                newAdj[j++] = adj[i];
            }
        }
        adj = newAdj;
        v--;
    }

    public void DFS(int v){
        boolean visited[] = new boolean[this.v];
        DFSUtils(v, visited);
    }
    public void DFSUtils(int v , boolean visited[]){
        visited[v] = true;
        System.out.print((v + " "));
        for(Integer neighbor : adj[v]){
            if(!visited[neighbor]){
                DFSUtils(neighbor, visited);
            }
        }
    }
    void BFS(int s){
        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()){
            s = queue.poll();
            System.out.print(s + " ");
            for(Integer neighbor : adj[s]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public void addVerticesAndEdgeFromIntut(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng đỉnh ban đầu: ");
        int initialVertices = Integer.parseInt(sc.nextLine());
        for(int i=0; i<initialVertices; i++){
            addVertex();
        }
        System.out.println("Nhập số lượng cạnh: ");
        int edges = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập các cạnh (định dạng: v w): ");
        for(int i=0; i<edges; i++){
            int v = sc.nextInt();
            int w= sc.nextInt();
            addEdge(v,w);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(0);
        g.addVerticesAndEdgeFromIntut();
        System.out.println("DFS bắt đầu từ đỉnh 0: ");
        g.DFS(0);
        System.out.println("\nBFS bắt dầu từ đỉnh 0: ");
        g.BFS(0);
    }
}
