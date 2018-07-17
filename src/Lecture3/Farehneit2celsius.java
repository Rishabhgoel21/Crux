package Lecture3;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class Farehneit2celsius {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		
		int minf=scn.nextInt();
		int maxf=scn.nextInt();
		int step = scn.nextInt();
		
		for(int i=minf; i<=maxf;i=i+step)
		{
			int c= (int) ((5.0/9)*(i-32));           //	int c= ((5)*(i-32))/9;
			
			System.out.println(i + "\t" + c);
		}
		
		
	}
	}
