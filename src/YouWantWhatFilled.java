/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;



/**
 *
 * @author allegea
 */
public class YouWantWhatFilled {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] grid;
    static boolean[][] visited;
    static int N, M, count;
    static char current;
   
    static boolean check(int i, int j)
    {
         //System.out.println(i+" ** "+j);
        return i>=0 && i<N && j>=0 && j<M && !visited[i][j] && grid[i][j] == current;
    }
   
    static void DFS(int i, int j)
    {
        if(!check(i, j))return;
        count++;
        visited[i][j] = true;
       
        for(int ii=0;ii<dx.length;ii++)
            DFS(i+dx[ii], j+dy[ii]);
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
       
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
       
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
         HashSet<Integer> insert;
         TreeMap<Integer, ArrayList<Character>> order;
        
           StringBuilder out = new StringBuilder();
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           int act = 0;
            while (true)
            {
                String[] read = in.readLine().split("[ ]+");
               N = Integer.parseInt(read[0]);
               M = Integer.parseInt(read[1]);
               if(N == 0 && M == 0)break;
              
               grid = new char[N][M];
               visited = new boolean[N][M];
               insert = new HashSet<Integer>();
               order = new TreeMap<Integer, ArrayList<Character>>();
               ArrayList<Character> aux;
              
               for(int i=0;i<N;i++)
                   grid[i] = in.readLine().toCharArray();
              
               for(int i=0;i<N;i++)
                   for(int j=0;j<M;j++)
                       if(!visited[i][j] && grid[i][j]!='.')
                       {
                           count = 0;
                           current = grid[i][j];
                           DFS(i, j);
                           //System.out.println(current+" - "+count);
                          
                           if(insert.contains(count))
                           {
                               order.get(count).add(current);
                           }else {
                               aux = new ArrayList<Character>();
                               insert.add(count);
                               aux.add(current);
                               order.put(count, aux);
                           }
                       }
              
              // System.out.println(order);
              // System.out.println(insert);
               Entry<Integer, ArrayList<Character>> answer;
               System.out.println("Problem "+(++act)+":");
               while(!order.isEmpty())
               {
                   answer = order.pollLastEntry();
                   aux = answer.getValue();
                   Collections.sort(aux);
                   for(int j=0;j<aux.size(); j++)
                       System.out.println(aux.get(j)+" "+ answer.getKey());
               }
               
            }

        //System.out.print(out.toString());
        in.close();
        System.exit(0);
       
    }
}