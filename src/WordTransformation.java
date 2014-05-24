/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Alejandro E. Garces
 */
public class WordTransformation {

    static boolean check(String s, String r)
    {
        int count = Math.abs(s.length()-r.length());
        int n = Math.min(s.length(), r.length());
        for(int i=0;i<n && count<2;i++)
            if(s.charAt(i)!=r.charAt(i))count++;
        
        if(count<2)return true;
        else return false;
    }
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         HashMap<String, Integer> map;
         Queue<String> q;
         int[] lenghts;
         boolean[] visited;
         ArrayList<String> words;
         ArrayList<String>[] nodes;
          
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
           in.readLine();
            while (act++<cases) 
            {
                
                int n = 0;
                map = new HashMap<String, Integer>();
                q = new LinkedList<String>();
                words = new ArrayList<String>();
                
               while(true)
               {
                   String aux = in.readLine();
                   if(aux.compareTo("*")==0)break;
                   map.put(aux, n++);
                   words.add(aux);
               }
               
               nodes = new ArrayList[n];
               
               for(int i=0;i<n;i++)
                   nodes[i] = new ArrayList<String>();
               
               for(int i=0;i<n-1;i++)
                   for(int j=i+1;j<n;j++)
                       if(check(words.get(i), words.get(j)))
                       {
                           nodes[i].add( words.get(j));
                           nodes[j].add( words.get(i));
                       }
               //System.out.println(map);
               
               while((line = in.readLine())!=null && line.length()>0)
               {
                   String[] read = line.split("[ ]+");
                   visited = new boolean[n];
                   lenghts = new int[n];
                   int u = map.get(read[0]);
                   visited[u] = true;
                   q.offer(read[0]);
                   
                   int answer = 0;
                   while(!q.isEmpty())
                   {
                       String v = q.poll();
                       u =  map.get(v);
                       if(v.compareTo(read[1])==0)
                       {
                           answer = lenghts[map.get(v)];
                           break;
                       }
                       
                       for(String s:nodes[u])
                       {
                           int x = map.get(s);
                           if(!visited[x])
                                   {
                                       visited[x] = true;
                                       lenghts[x] = lenghts[u]+1;
                                       q.offer(s);
                                   }
                       }
                       
                       /*
                       for(int i=0;i<v.length();i++)
                       {
                           char[] aux = v.toCharArray();
                           for(char a='a';a<='z';a++)
                           {
                               aux[i] = a;
                               String transformation = String.valueOf(aux);
                               if(map.containsKey(transformation))
                               {
                                   int j = map.get(transformation);
                                   if(!visited[j])
                                   {
                                       visited[j] = true;
                                       lenghts[j] = lenghts[u]+1;
                                       q.offer(transformation);
                                   }
                               }
                           }
                       }*/
                   }
                   
                   System.out.println(read[0]+" "+read[1]+" "+answer);
                           
               }
                System.out.println();
            }

        in.close();
        System.exit(0);
        
    }
}
