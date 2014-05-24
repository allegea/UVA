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
public class TransactionProcessing {

   public static void main(String[] args) throws IOException{
         //String file = "test";  
        //System.setIn(new FileInputStream(file+".txt"));
        //System.setOut(new PrintStream(new FileOutputStream(file+"O.txt")));
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         String[] accounts = new String[1000];
         String line = "";
         while(true)
         {
             line = in.readLine();
             int size = line.length();
             String number = line.substring(0, 3);
             String value = line.substring(3, size);
             if(number.equals("000"))break;
             accounts[Integer.parseInt(number)] = value;
         }
         
         
         boolean ends = false;
         line = in.readLine();
         boolean noFirst = false;
         while(!ends)
         {
             
             boolean first = true;
             long amount = 0;
             String tranName = "";
             ArrayList<Integer> amo = new ArrayList<Integer>();
             ArrayList<Integer> acc = new ArrayList<Integer>();
             while(true)
             {
                
                int size = line.length();
                String trans = line.substring(0, 6);
                if(trans.equals("000000")){
                    ends = true;
                    break;
                } 
                String ac = trans.substring(3, 6);
                trans = trans.substring(0, 3);
                //System.out.println(trans+"---"+tranName);
                        
                if(first)
                tranName = trans;
                else if(!tranName.equals(trans))break;
                first = false;
                
                String am = line.substring(6, size);
                int value = Integer.parseInt(am.trim());
                amount+=value;
                amo.add(value);
                acc.add(Integer.parseInt(ac));
                
                line = in.readLine();
             }
              //System.out.println("** "+amount+" **");
             if(amount != 0)
             {
                 amount*=-1;
                 double newAmount = amount/100.0;
                 //if(noFirst)System.out.println();
                 noFirst = true;
                 System.out.println("*** Transaction " + tranName+" is out of balance ***");
                 for(int i = 0; i <acc.size(); i++)
                 System.out.printf(Locale.ENGLISH,"%s %-30s %10.2f\n",acc.get(i), accounts[acc.get(i)], (double)amo.get(i)/100);
                 System.out.printf(Locale.ENGLISH,"%d %-30s %10.2f\n\n", 999, "Out of Balance" ,newAmount);
                 

             }
            
             
             
         }
         in.close();
         System.exit(0);
     }
}
