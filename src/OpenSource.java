/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class OpenSource {

    public static class Answer implements Comparable<Answer>{
        
        String name;
        int count;
        Answer(String n, int c)
        {
            name = n;
            count = c;
        }
        @Override
        public int compareTo(Answer o)
        {
            if(this.count == o.count)
                return this.name.compareTo(o.name);
            return o.count - this.count;
        }
        
        @Override
        public String toString()
        {
            return name + " " + count;
        }
    }
   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         HashSet<String> users;
         ArrayList<HashSet<String>> usersXSource;
         ArrayList<String> sources;
         
         while(true)
         {
             String line  = in.readLine();
             if(line.compareTo("0") == 0)break;
             users = new HashSet<String>();
             sources = new ArrayList<String>();
             usersXSource =  new ArrayList<HashSet<String>>();
             int size = 0;
             while(true){
                 if(line.compareTo("1") == 0)break;
                 String upper = line.toUpperCase();
                 if(upper.compareTo(line) == 0)
                 {
                     sources.add(line);
                     usersXSource.add(new HashSet<String>());
                     size++;
                 }else{
                     usersXSource.get(size - 1).add(line);
                     users.add(line);
                 }
                // System.out.println(size);
                 line = in.readLine();
             }
             
             for(String x:users)
             {
                 int count = 0;
                 for(int i = 0; i < usersXSource.size(); i++)
                     if(usersXSource.get(i).contains(x))
                         count++;
                 //System.out.println(x + " - " + count);
                 
                 if(count > 1)
                 {
                     for(int i = 0; i < usersXSource.size(); i++)
                        if(usersXSource.get(i).contains(x))
                            usersXSource.get(i).remove(x);
                 }
             }
             
             Answer[] output = new Answer[sources.size()];
             for(int i = 0; i < sources.size(); i++)
                 output[i] = new Answer(sources.get(i), usersXSource.get(i).size());
             
             Arrays.sort(output);
             
             for(Answer x:output)
                 System.out.println(x.toString());
             
             
         }
         in.close();
         System.exit(0);
     }
}
