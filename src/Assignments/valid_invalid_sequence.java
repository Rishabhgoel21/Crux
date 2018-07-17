package Assignments;
/**
 * @author Rishabh
 */
import java.util.Scanner;

public class valid_invalid_sequence {

	static Scanner scn = new Scanner(System.in);

	/*
	 * Take the following as input. A number (N) Take N more numerical inputs The N
	 * inputs for a sequence S = s1, s2, .., sN. Compute if it is possible to split
	 * sequence into two sequences - s1 to si and si+1 to sN such that first
	 * sequence is strictly decreasing and second is strictly increasing. Print
	 * true/false as output.
	 */

	public static void main(String[] args) {

		int n = scn.nextInt();
		
		        int s = 0;
		        int flaginc = 0;
		        int flagdec = 0;
		        int done = 0;
		
		        int prev = scn.nextInt();
		        for (int i = 1; i < n; i++) {
		            s = scn.nextInt();
		            if (s > prev && flaginc == 0) {
		                flaginc = 1;
		            } else if (prev > s && flaginc == 1) {
		                done = 1;
		                System.out.println("false");
		                break;
		            }
		            if (s < prev && flagdec == 0) {
		                flagdec = 1;
		            }
		            prev = s;
		        }
		        if (done == 0)
		            System.out.println("true");
		    }
		}