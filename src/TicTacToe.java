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
class TicTacToe
{
	static boolean won(char[][] board, char x)
	{
		boolean found1 = false;
		boolean found2 = false;
		boolean found3 = false;
		boolean found4 = false;
		for(int i = 0;i<3 && !(found1|found2|found3|found4);i++)
		{
			found1 = found2 = found3 = found4 = true ;
			for(int j = 0;j<3;j++)
			{
				found1&=(board[i][j]==x);
				found2&=(board[j][i]==x);
				found3&=(board[j][3-j-1]==x);
				found4&=(board[3-j-1][j]==x);
			}
                        
                        //System.out.println(found1+ " - "+ found2+ " - "+ found3 + " - "+ found4); 
		}
		
		if(found1 || found2 || found3 || found4)return true;
                return false;
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int curr = 0;
		char[][] board;
		while(true)
		{
			board = new char[3][3];
			for(int i = 0;i<3;i++)
				board[i] = in.readLine().toCharArray();
			
			int X = 0;
			int O = 0;
			
			for(int i = 0;i<3;i++)
				for(int j = 0;j<3;j++)
					if(board[i][j] == 'X')X++;
					else if(board[i][j] == 'O') O++;
					
			boolean foundX = won(board, 'X');
			boolean foundO = won(board, 'O');
                        //System.out.println(X+" - "+O+" - "+foundX+" - "+foundO);
                        if(O > X)System.out.println("no");
                        else if(O == X && !foundX && foundO)System.out.println("yes");
                        if(O < X && !foundX && foundO)System.out.println("no");
                        else if(X == O+1)System.out.println("yes");
                        else System.out.println("no");
                        
                        if(++curr<n)in.readLine();
                        else break;
			
			
		}
		in.close();
		System.exit(0);
	}
}f
/*
 34
XXX
XOO
XOO

OXX
XOO
XXO

X..
X..
X..

X..
X..
O..

X.X
...
.X.

O.O
...
.O.

X.O
XO.
XOX

X.O
XOO
XXX

OXO
XXX
OXO

XXX
.O.
.O.

OOO
.X.
.X.

XOX
OXO
XOX

XXX
OOO
X.O

X.O
..X
X..

X.X
.OO
XOO

X.X
OO.
X.X

X.O
O.X
X.O

X.O
OO.
XXX

X.O
O.X
OOX

X.O
O..
XXO

X.O
O.O
X..

...
...
...

...
.X.
...

...
.O.
...

OO.
XXO
X.O

XXX
XXX
XXX

OOO
OOO
OOO

.O.
XXX
.O.

.X.
OOO
.X.

X.O
.X.
O.X

OXO
OXX
X.O

XXX
.OO
OX.

OOO
.XX
X.X

XO.
XO.
XOO
 */