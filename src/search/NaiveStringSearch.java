package search;

//Java program for Naive Pattern Searching

public class NaiveStringSearch {

	static void search(String pat, String txt)
	{
		int l1 = pat.length();
		int l2 = txt.length();
		int i = 0, j = l2 - 1;

		for (i = 0, j = l2 - 1; j < l1;) {

			if (txt.equals(pat.substring(i, j + 1))) {
				System.out.println("Pattern found at index "
								+ i);
			}
			i++;
			j++;
		}
	}
	
	// Driver's code
	public static void main(String args[])
	{
		String pat = "AABAACAADAABAAABAA";
		String txt = "AABA";
	
		// Function call
		search(pat, txt);
	}
}
//This code is contributed by D. Vishnu Rahul Varma

//String str = "lorie lololed";
//String s = "lol";
//int count = 0;
//for(int i = 0; i < str.length(); i++) {
//	for(int j = 0; j < s.length(); j++) {
//		System.out.println(s.charAt(j) + " " + str.charAt(i+j));
//		if(s.charAt(j) != str.charAt(i+j)) {
//			System.out.println("break!!");
//			break;
//		}
//		if(j == s.length() - 1) {
//			count++;
//			
//		}
//		
//	}
//}
//System.out.println("개수 " +count);
