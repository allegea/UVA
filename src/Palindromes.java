/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;



/**
 *
 * @author allegea
 */
public class Palindromes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
           String line;
            while ((line = in.readLine()) != null) 
            {
               boolean palind = palindrom(line);
               boolean mirro = mirrored(line);
               if(palind && mirro)
                System.out.println(line+" -- is a mirrored palindrome.\n");
               if(!palind && mirro)
                System.out.println(line+" -- is a mirrored string.\n");
               if(palind && !mirro)
                System.out.println(line+" -- is a regular palindrome.\n");
               if(!palind && !mirro)
                System.out.println(line+" -- is not a palindrome.\n");
                
            }

        in.close();
        System.exit(0);
        
    }
    
    static boolean palindrom(String word)
    {
        
        char[] letters = word.toCharArray();
        int size = word.length();
        for(int i=0;i<size/2;i++)
            if(letters[i]!=letters[size-i-1])return false;
        
        return true;
    }
    
    static boolean mirrored(String word)
    {
        //char[] digits =new char['1','S','E','-','Z','-','-','8','-'];
        String aux = "1SE-Z--8-";
        char[] digits =aux.toCharArray();
        
        aux = "A---3--HIL-JM-O---2TUVWXY5";
        char[] let =aux.toCharArray();
        
        char[] letters = word.toCharArray();
        int size = word.length();
        for(int i=0;i<=size/2;i++)
        {
            if(Character.isLetter(letters[i]))
            {
                if(let[letters[i]-65]=='-')return false;
                if(let[letters[i]-65]!=letters[size-i-1])return false;
               // System.out.print(let[letters[i]-65]);
            }
            else
            {
                if(digits[letters[i]-49]=='-')return false;
                if(digits[letters[i]-49]!=letters[size-i-1])return false;
                //System.out.print(digits[letters[i]-49]);
            }
                
           
            
        }
        return true;
    }
}
