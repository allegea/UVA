/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
555
/**
 *
 * @author Alejandro E. Garces
 */
public class HowManyFibs {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
         BigInteger[] fibo = new BigInteger[481];
         fibo[0] = BigInteger.ZERO;
         fibo[1] = BigInteger.ONE;
         fibo[2] = fibo[1].add(BigInteger.ONE);
         BigInteger limit = new BigInteger("10");
         limit = limit.pow(100);
         int i=3;
         
         do{
             fibo[i] = fibo[i-1].add(fibo[i-2]);
             //System.out.println(fibo[i].toString());
         }while(fibo[i++].compareTo(limit)<0);

         
         
            while (true) 
            {
               String[] input = in.readLine().split("[ ]+");

               if(input[0].equals(input[1]) && input[0].equals("0"))
                   break;
               
               int inda = 0;
               
               
               
               BigInteger a = new BigInteger(input[0]);
               BigInteger b = new BigInteger(input[1]);
               
               if(a.compareTo(b)>0)
               {
                   BigInteger tem = a;
                   a = b;
                   b = tem;
               }
               while(fibo[inda].compareTo(a)<0)inda++;
               
               int indb = 0;
               
               while(fibo[indb].compareTo(b)<0)indb++;
               
               /*int an = Arrays.binarySearch(fibo,new BigInteger(input[0]));
               int am = Arrays.binarySearch(fibo,new BigInteger(input[1]));
               
               int answer = -1;
               if(an>=0 && am>=0)answer=am-an+1;
               else if(an >=0 || am>=0)answer = Math.abs(Math.abs(am)-Math.abs(an));
               else answer = Math.abs(am-an);*/
               int answer = 0;
               if(fibo[indb].compareTo(b)==0)answer = indb-inda+1;
               else answer = indb-inda;
               System.out.println(answer); 
                
            }

        in.close();
        System.exit(0);
        
    }
}

/*
10 100
100 1000
5000 9000
1234000 123456000
5567 900000000
34556 10000000000000
43324234 85675676576575675675
8678678 345345345345345345353453453
235432435425 4364364653453646353643645656345646345
1 100000000000000000000000
234134 454765765674567457645
123421341234234 3465546345465634546564636
453643644654656645 45645465645465564645465654465465645
1 2
1 5
5 5
6 7
4 5
1 1
334 45564645
4356 56765878768787678768657856785576
23545 6547657457665
234535 46765758908765432
12 500000000000
45 9000000000000000000000000000000000
2354 566546456456456746545765464564
0 0*/

/*5
5
1
10
25
40
59
94
120
110
73
50
81
2
4
1
0
1
1
25
134
40
54
51
155
127*/