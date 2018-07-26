package com.yjy.algorithm;

import java.io.InputStream;
import java.util.LinkedList;

import edu.princeton.cs.algs4.In;

/**
 * <pre>
 *     author : yjy
 *     e-mail : yujunyu12@gmail.com
 *     time   : 2018/07/26
 *     desc   :图
 *     version: 1.0
 * </pre>
 */

public class Graph {
    //顶点数目
    private int V;
    //边数目
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[])new LinkedList[V];
        for(int i=0;i<V;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public Graph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i=0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            System.out.println("v:"+v+"  "+"w: "+w);
            addEdge(v,w);
        }

    }



    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }


    public Iterable<Integer> adj(int v){
        return adj[v];
    }





}
