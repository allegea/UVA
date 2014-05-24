/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author Alejandro E. Garces
 */
public class CarefulTeacher {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

         HashSet<String> dicc = new HashSet<String>();
         String read="";
         while(true){
             read = in.readLine();
             if(read.equals("--"))break;
             dicc.add(read);
         }
        
            while ((read=in.readLine())!=null) 
            {
                String[] words = read.split("[ ]+");
                HashSet<String> visited = new HashSet<String>();
                java.util.Queue<String> x = new LinkedList<String>();
                x.offer(words[0]);
                boolean answer = false;
                while(!x.isEmpty())
                {
                    String aux = x.poll();
                    if(aux.equals(words[1])){
                        answer = true;
                        break;
                    }
                    String newS = "";
                    visited.add(aux);
                    char au;
                    char[] auxA = aux.toCharArray();
                    for(int i=0;i<aux.length();i++){
                        au = auxA[i];
                        for(char j='a';j<='z';j++)
                        {   
                            auxA[i]=j;
                            newS = String.valueOf(auxA);
                            if(dicc.contains(newS))
                            {   if(visited.add(newS))
                                    x.offer(newS);
                            }
                            
                        }
                        auxA[i]=au;
                    }
                }
                //System.out.println(visited);
                if(answer)
                    System.out.println("Yes");
                else System.out.println("No");
            }

        in.close();
        System.exit(0);
        
    }
}
