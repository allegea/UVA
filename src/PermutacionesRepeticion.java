
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author allegea
 */
public class PermutacionesRepeticion {
    static int p = 1;
    public static void main(String[] args){
    LinkedList<Character> conjunto =new LinkedList<Character>();
        conjunto.add('1');
        conjunto.add('2');
        conjunto.add('3');
        conjunto.add('4');
        conjunto.add('5');
        
        escribe ("", conjunto);
    }

    public static void escribe(String a, LinkedList<Character> conjunto) {
        if (conjunto.size()==1)
        {
            System.out.println(a+conjunto.get(0)+" - "+(p++));
            
        }
        for (int i=0;i<conjunto.size();i++)
        {
            Character b = conjunto.remove(i);
            escribe (a+b, conjunto);
            conjunto.add(i,b);
        }
    }
    
    static void solve(int[] b, int k) {
        if (k == n) {
            System.out.println(Arrays.toString(b));
        }

        for (int i = 0; i < n; ++i) {
            if (used[ i]) {
                continue;
            }
            used[ i] = true;
            b[ k] = original[i];
            solve(b, k + 1);
            used[ i] = false;
        }
    }

}
