package HashMap;

/**
 * @author Rishabh
 * 
 * @date 04-Jul-2018
 */

public class HuffmanClient {

	public static void main(String[] args) {

		HuffmanCoding hf = new HuffmanCoding("aaaaabbbbbbbbccdddd");

		System.out.println(hf.encode("abcda"));
		System.out.println(hf.decode("10011011110"));

	}

}
