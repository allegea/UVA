/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
a
import java.util.*;

import java.io.*;




/**
 *
 * @author allegea
 */
public class TheDecoder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) /*throws IOException*/{
        //Scanner in = new Scanner(new File("pruebas.txt"));
  
        //Scanner in = new Scanner(System.in);
        try{
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
            DataInputStream in = new DataInputStream(System.in);
            
       //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        
        //String line = in.readLine();
        /*  String line=  in.readUTF();
        char[] charac = line.toCharArray();
        while(!line.isEmpty())
        {
            for(int i=0;i<line.length();i++)
            {
                //System.out.print((char)(line.charAt(i)-7));
                charac[i] = (char)(charac[i]-7);
            }
            
            System.out.println(charac);
            
            line = in.readLine();
            charac = line.toCharArray();

        }*/
            
            while(true)
            {
                //char letter = in.readChar();
                String line = in.readLine();
                
                for(int i=0;i<line.length();i++)
                {
                if( line.charAt(i) != 13)
                    //if(line.charAt(i)!=10)
                System.out.print((char)(line.charAt(i)));
                else
                        System.out.println();
                }
            }
        }
        catch(IOException e)
        {
            System.exit(0);
        }
 
        
        System.exit(0);

    }
}
