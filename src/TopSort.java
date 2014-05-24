/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author allegea
 */

   
import java.util.Arrays;
import java.util.HashMap;  
import java.util.HashSet;  
import java.util.LinkedList;  
import java.util.Map;  
import java.util.Queue;  
import java.util.Set;  
import java.util.Iterator;  
   
public class TopSort {  
   
    public static String[] topologicalSort(MyData[] data) throws Exception {

        /* 
         * Q ? Set of all nodes with no incoming edges while Q is non-empty do 
         * remove a node n from Q output n for each node m with an edge e from n 
         * to m do remove edge e from the graph if m has no other incoming edges 
         * then insert m into Q if graph has edges then output error message 
         * (graph has a cycle) 
         */
        int n = data.length;
        Map graph = new HashMap();
        Queue q = new LinkedList();
        String[] sorted = new String[n];
// Graph construction  
        for (int i = 0; i < data.length; i++) {
// for each statistic name s  
            graph.put(data[i].job, new HashSet());
            String[] requiredJobs = data[i].others;
            ((Set) graph.get(data[i].job)).addAll(Arrays.asList(requiredJobs));
// Initial nodes in q  
            if (((Set) graph.get(data[i].job)).isEmpty()) {
                q.add(data[i].job);
            }
        }

// Getting the nodes in sorted order  
        int index = 0;
        while (q.size() > 0) {
            String s = (String) q.remove();
            sorted[index++] = s;
            Iterator iter = graph.keySet().iterator();
            while (iter.hasNext()) {
// for each key in graph  
// check if node is not already removed  
                Object key = iter.next();
                if (!((Set) graph.get(key)).isEmpty()) {
                    ((Set) graph.get(key)).remove(s);
// if this node now has zero incoming edges  
                    if (((Set) graph.get(key)).isEmpty()) {
                        q.add(key);
                    }
                }
            }
        }

        if (index < n) {
            throw new Exception("Cycle detected, exiting ....");
        }

        return sorted;
    }

    public static void main(String[] args) throws Exception {
        /*MyData d1 = new MyData("job1", new String[]{"job3", "job5", "job4"});
        MyData d2 = new MyData("job3", new String[]{"job5", "job6"});
        MyData d3 = new MyData("job4", new String[]{"job2", "job7"});
        MyData d4 = new MyData("job7", new String[]{"job1", "job2", "job4"});
        String[] sorted = TopSort.topologicalSort(new MyData[]{d1, d2, d3, d4});*/
            MyData d1 = new MyData("7",new String [] {"11","8"});  
    MyData d2 = new MyData("5",new String [] {"11"});  
    MyData d3 = new MyData("3",new String [] {"8","10"});  
    MyData d4 = new MyData("11",new String [] {"2","9","10"});  
    MyData d5 = new MyData("8",new String [] {"9"});  
    MyData d6 = new MyData("2",new String [] {});  
    MyData d7 = new MyData("9",new String [] {});  
    MyData d8 = new MyData("10",new String [] {});  
    String [] sorted = TopSort.topologicalSort(new MyData [] {d1,d2,d3,d4,d5,d6,d7,d8});  
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i]+ " ");
        }


    }
}

class MyData {

    public String job;
    public String[] others;

    public MyData(String job, String[] other) {
        this.job = job;
        this.others = other;
    }
}
