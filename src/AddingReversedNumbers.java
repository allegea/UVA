/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.math.BigInteger;


import java.util.*;

/**
 *
 * @author allegea
 */
public class AddingReversedNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
       // BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         
           String line;
           line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;
            while (act++<cases) 
            {
                StringTokenizer dates = new StringTokenizer(in.readLine());
                String first = dates.nextToken();
                String first2 = "";
                for(int i=first.length()-1;i>=0;i--)
                    first2+=first.charAt(i)+"";
                
                String second = dates.nextToken();
                String second2 = "";
                for(int i=second.length()-1;i>=0;i--)
                    second2+=second.charAt(i)+"";
                
                BigInteger sum = new BigInteger(first2);
                sum = sum.add(new BigInteger(second2));
                
           
                 String result = sum.toString();
                 //System.out.println(result);
                String result2 = "";
                for(int i=result.length()-1;i>=0;i--)
                    result2+=result.charAt(i)+"";
                
                System.out.println( new BigInteger(result2).toString());
                
        
                
                
            }

        in.close();
        System.exit(0);
        
    }
}

/*
 * 
 * import java.util.*;
import java.io.*;
import java.math.*;

public class AddingReversedNumbers {

public static void main(String[] args) throws IOException {
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

int T = Integer.parseInt(in.readLine());
while (T-- > 0) {
String[] parts = in.readLine().split("[ ]");
BigInteger n1 = new BigInteger(new StringBuffer(parts[0]).reverse().toString());
BigInteger n2 = new BigInteger(new StringBuffer(parts[1]).reverse().toString());

String res = new StringBuffer(n1.add(n2).toString()).reverse().toString();
while (res.length() > 1 && res.charAt(0) == '0')
res = res.substring(1);
System.out.println(res);
}

in.close();
System.exit(0);
}
}
 */