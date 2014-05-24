/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Alejandro E. Garces
 */
public class I_Can_Guess_the_Data_Structure {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws IOException{
        
        //BufferedReader in   = new BufferedReader(new FileReader("pruebas.txt"));
        
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
           PriorityQueue<Integer> priority;
           Queue<Integer> queue;
           Stack<Integer> stack;
           
           String line;
           /*line = in.readLine();
           int cases = Integer.parseInt(line);
           int act = 0;*/
           StringBuilder out = new StringBuilder();

            while ((line = in.readLine()) != null) 
            {
               
               int n= Integer.parseInt(line);
               int a,b,x;
               priority = new PriorityQueue<Integer>();
               queue = new LinkedList<Integer>();
               stack = new Stack<Integer>();
               String[] read;
               boolean p=true,q=true,s=true;
               for(int i=0;i<n;i++)
               {
                   
                   
                   read = in.readLine().split("[ ]+");
                   a = Integer.parseInt(read[0].trim());
                   b = Integer.parseInt(read[1].trim());
                   
                   if(a==1)
                   {
                       if(p)
                       priority.offer(-b);
                       if(q)
                       queue.offer(b);
                       if(s)
                       stack.push(b);
                   }else{
                        if(p)
                        {
                            
                            if(!priority.isEmpty() && b!=(-priority.poll()))
                            p=false;
                            //else priority.poll();
                        }
                        
                        if(q)
                        {
                            if(!queue.isEmpty() && b!=queue.poll())
                            q=false;
                           // else queue.poll();
                                    
                        }
                        
                        if(s)
                        {
                            if(!stack.isEmpty()&& b!=stack.pop())
                             s=false;
                           // else stack.pop();
                        }
                       
                       
                       if(!s && !q && !p)
                       {    //System.out.println(answer);
                           while(++i<n) in.readLine();
                       }
                   }
                   
                   //System.out.println(answer);
               }
               
               
               if(!s && !q && p )
                   out.append("priority queue\n");
               else if(!s && q && !p)
                   out.append("queue\n");
               else if(s && !q && !p)
                   out.append("stack\n");
               else if(!s && !q && !p)
                   out.append("impossible\n");
               else out.append("not sure\n");
                
                               // System.out.print(out.toString());

            }
            
            System.out.print(out.toString());
        in.close();
        System.exit(0);
        
    }
}
/*
 * import java.io.*;
import java.util.*;

public class ICanGuessTheDataStructure {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		String line;
		Queue<Integer> Q;
		Stack<Integer> S;
		PriorityQueue<Integer> PQ;
		boolean isQueue;
		boolean isStack;
		boolean isPQueue;

		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			Q = new LinkedList<Integer>();
			S = new Stack<Integer>();
			PQ = new PriorityQueue<Integer>();

			isQueue = true;
			isStack = true;
			isPQueue = true;

			while (N-- > 0) {
				String[] parts = in.readLine().split("[ ]+");
				int command = Integer.parseInt(parts[0].trim());
				int value = Integer.parseInt(parts[1].trim());

				if (command == 1) {
					if (isQueue)
						Q.offer(value);
					if (isStack)
						S.push(value);
					if (isPQueue)
						PQ.offer(-value);
				} else {
					if (isQueue && (Q.isEmpty() || Q.poll() != value))
						isQueue = false;
					if (isStack && (S.isEmpty() || S.pop() != value)) 
						isStack = false;
					if (isPQueue && (PQ.isEmpty() || PQ.poll() != -value))
						isPQueue = false;
				}
			}
			if (isQueue && !isStack && !isPQueue)
				sb.append("queue\n");
			else if (!isQueue && isStack && !isPQueue)
				sb.append("stack\n");
			else if (!isQueue && !isStack && isPQueue)
				sb.append("priority queue\n");
			else if (!isQueue && !isStack && !isPQueue)
				sb.append("impossible\n");
			else 
				sb.append("not sure\n");
		}
		System.out.print(sb.toString());

		in.close();
		System.exit(0);
	}
}
 */