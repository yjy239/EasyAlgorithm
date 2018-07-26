package com.yjy.algorithm;

import android.util.Log;

import java.util.Iterator;

import edu.princeton.cs.algs4.In;

/**
 * <pre>
 *     author : yjy
 *     e-mail : yujunyu12@gmail.com
 *     time   : 2018/07/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class Test {

    public static void main(String[] args){
        In in = new In("D:\\demo\\algs4-data\\tinyCG.txt");
        Graph G = new Graph(in);
        DeepFirstSearchPaths dfp = new DeepFirstSearchPaths(G,0);
        for(int v=0;v<G.V();v++){
            System.out.println(0+"->"+v+": ");
            if(dfp.hasPathTo(v)){
                for(int x : dfp.pathTo(v)){
                    if(x == 0){
                        System.out.println(x);
                    }else{
                        System.out.println("->"+x);
                    }
                }
            }
        }
//        Iterable<Integer> paths = dfp.pathTo(5);
//        if(paths!=null&&paths.iterator() != null){
//            Iterator<Integer> it = paths.iterator();
//            while (it.hasNext()){
//                System.out.println("->"+it.next());
//            }
//        }

    }

}
