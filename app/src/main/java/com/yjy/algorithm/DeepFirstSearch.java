package com.yjy.algorithm;

/**
 * <pre>
 *     author : yjy
 *     e-mail : yujunyu12@gmail.com
 *     time   : 2018/07/26
 *     desc   :深度优先搜索 策略:每一次跑过一个顶点标志已经跑过了，不断的向下探索，直到探索的尽头。
 *     达到尽头之后，开始回退到上一个节点选取另一个没有探索过的节点继续探索，直到遍历完整个图或者树
 *     version: 1.0
 * </pre>
 */

public class DeepFirstSearch {
    //记录已经跑了多少顶点
    private boolean[] marked;
    //跑了多少次
    private int count;

    /**
     *
     * @param G 图
     * @param s 原节点
     */
    public DeepFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    public void dfs(Graph G,int v){
        marked[v] = true;
        count++;

        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public int count(){
        return count;
    }


}
