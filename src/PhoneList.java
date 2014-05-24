/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.TreeSet;

/**
 *
 * @author allegea
 */
public class PhoneList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
             
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
               int numbers = Integer.parseInt(in.readLine());
              // char[][] phones = new char[numbers][10];
                TreeSet<String> phones = new TreeSet<String>();
               //int[] sizes = new int[numbers];
               boolean answer = true;
               for(int i=0;i<numbers;i++)
               {    phones.add(in.readLine());
                    //sizes[i]=phones[i].length;
               }
               
               boolean first=true;
               String bef="";
               for(String s:phones)
               {
                   if(first)
                   {
                       first=false;
                       bef=s;
                   }
                   else
                   {
                       if(s.startsWith(bef))
                       {
                           answer=false;
                           break;
                       }
                       bef=s;
                   }
                   
               }
               
  
               
               
               
               if(answer)System.out.println("YES");
               else System.out.println("NO");
                
            }

        in.close();
        System.exit(0);
        
    }
}
