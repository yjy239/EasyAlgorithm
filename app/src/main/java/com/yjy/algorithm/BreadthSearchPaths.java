package com.yjy.algorithm;


import java.util.Stack;

import edu.princeton.cs.algs4.Queue;

/**
 * <pre>
 *     author : yjy
 *     e-mail : yujunyu12@gmail.com
 *     time   : 2018/07/26
 *     desc   :广度优先算法
 *     version: 1.0
 * </pre>
 */

public class BreadthSearchPaths {
    private boolean[] markeds;
    //数组对应下标的每一个顶点链接到最后点，由于一个顶点可能联通多个末点
    private int[] edgeTo;
    private int s;

    public BreadthSearchPaths(Graph G,int s){
        markeds = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    /**
     * 为的是把所有的edgeTo的数组标记出来
     * @param G
     * @param s
     */
    public void bfs(Graph G,int s){
        Queue<Integer> queue = new Queue<>();
        markeds[s] = true;
        queue.enqueue(s);
        while(!queue.isEmpty()){
            int v = queue.dequeue();
            for(int w:G.adj(v)){
                if(!markeds[w]){
                    edgeTo[w] = v;
                    markeds[w] = true;
                    queue.enqueue(w);
                }
            }
        }


    }

    public boolean hasPathTo(int v){
        return markeds[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }

        Stack<Integer> paths = new Stack<>();

        for(int x = v;x != s;x=edgeTo[x]){
            paths.push(x);
        }

        paths.push(s);


        return paths;


    }
}
