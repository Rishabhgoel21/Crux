package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

/*Write a program that works as a simple calculator.

		1.It reads a character (ch)
		2.If ch is among '+', '-', '*', '/' or '%' it furthur takes two numbers (N1 and N2 
		as input). It then performs appropriate appropriate operation between numbers and
		 print the number. 3.If ch is 'X' or 'x', the program terminates.
		4.If ch is any other character, the program should print 'Invalid operation.
		 Try again.' and seek inputs again (starting from character).

		Write code to achieve above functionality.
*/	
public class Calculator {
    static Scanner scn= new Scanner(System.in);
    public static void main(String args[]) {
    
         char ch;
        
        do{ ch=scn.next().charAt(0);
        
         
        if(ch=='+'|| ch=='-'|| ch=='*'||ch=='/'|| ch=='%')
        calculate(ch);
        else if(ch!='x' &&ch!='X')
                System.out.println("Invalid operation. Try again.");
            
    }while(ch!='x' &&  ch!='X');
        
    }
    
    public static void calculate(char ch)
    {
         int n1 = scn.nextInt();
        int  n2 =scn.nextInt();
        int ans=0;
        if(ch=='+')
        {
            ans=n1+n2;
            System.out.println(ans);
        }
        else
            if(ch=='-')
            {
                ans=n1-n2;
                System.out.println(ans);
            }
            else
                if(ch=='*')
                {
                    ans=n1*n2;
                    System.out.println(ans);
                }
                else
                    if(ch=='/')
                    {
                        ans=n1/n2;
                        System.out.println(ans);
                    }
                    else
                        if(ch=='%')
                        {
                            ans=n1%n2;
                            System.out.println(ans);
                        }
    }
}
