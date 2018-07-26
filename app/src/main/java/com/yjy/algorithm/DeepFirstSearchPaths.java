package com.yjy.algorithm;

import java.util.Iterator;
import java.util.Stack;

/**
 * <pre>
 *     author : yjy
 *     e-mail : yujunyu12@gmail.com
 *     time   : 2018/07/26
 *     desc   :递归方式
 *     version: 1.0
 * </pre>
 */

public class DeepFirstSearchPaths {
    private boolean[] markeds;
    //数组对应下标的每一个顶点链接到最后点，由于一个顶点可能联通多个末点
    private int[] edgeTo;
    private int s;


    public DeepFirstSearchPaths(Graph G,int s){
        markeds = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs2(G,s);
    }

    public void dfs(Graph G,int s){
        markeds[s] = true;
        for(int w:G.adj(s)){
            if(!markeds[w]){
                edgeTo[w] = s;
                dfs(G,w);
            }
        }
    }

    //非递归方式
    public void dfs2(Graph G,int s){
        Stack<Integer> stack = new Stack<>();
        markeds[s] = true;
        pushDegree(stack,G,s);
        //把扩展的路劲压入stack中
        while (!stack.empty()){
            int v = stack.pop();
            for(int w : G.adj(v)){
                if(!markeds[w]){
                    markeds[w] = true;
                    edgeTo[w] = v;
                    pushDegree(stack,G,w);
                }
            }
        }

    }

    public Stack<Integer> pushDegree(Stack<Integer> stack,Graph G,int s){
        for(int v : G.adj(s)){
            stack.push(v);
        }
        return stack;
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
