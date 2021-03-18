
public class RemovePalindromic {
		
	public int removePalindromic(String s) {
		if (s.isEmpty()) return 0;
		
		for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return 2;
			}
		}
		
		return 1;
	}

	public static void main(String[] args) {
		RemovePalindromic rp = new RemovePalindromic();
		
		System.out.println(rp.removePalindromic("abbaabab"));
	}

}
