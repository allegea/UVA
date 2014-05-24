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
public class Dates {

    public static void main(String[] args) throws IOException{
	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November","December"};
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int cases = 1;
        Date answer;
        while(n-->0)
        {
            Calendar now = Calendar.getInstance();
            String[] read = in.readLine().split("-");
            int up = Integer.parseInt(in.readLine());
            int year = Integer.parseInt(read[0]);
            int mont = 0;
            for(int i=0;i<months.length;i++)
                if(months[i].equals(read[1]))
                {
                    mont = i;
                    break;
                }
           int day = Integer.parseInt(read[2]);
            now.set(year, mont, day);
            now.add(Calendar.DATE, up);
            answer = now.getTime();
            String mon = months[now.get(now.MONTH)];
            String da = ""+now.get(now.DATE);
            if(da.length() == 1) da="0"+da;
            System.out.println("Case "+cases+": "+now.get(now.YEAR)+"-"+mon+"-"+da);
           // System.out.println("Case "+cases+": "+answer.getYear()+"-"+answer.getMonth()+"-"+answer.getDay());
            cases++;
        }
        in.close();
        System.exit(0);
        
                
    }
}
