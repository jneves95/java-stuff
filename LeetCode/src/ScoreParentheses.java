import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Given a string of balanced parentheses, computes its score based on the following conditions:
 * 1) "()" = 1
 * 2) "AB" = A + B where A and B are balanced parentheses substrings
 * 3) (A) = 2 * A 
 * 
 * (()(()))
 * 
 * ( -> [-1]
 * 
 * ()(()))
 * 
 * ( -> [-1, -1]
 * 
 * )(()))
 * 
 * ) -> [1, -1]
 * 
 * (()))
 * 
 * ( -> [-1, 1, -1]
 * 
 * ()))
 * 
 * ( -> [-1, -1, 1, -1]
 * 
 * )))
 * 
 * ) -> [1, -1, 1, -1]
 * 
 * ))
 * 
 * ) -> x = 0 + 1 = 1 [-1, 1, -1] -> x *= 2 = 2 [1, -1] -> [2, 1, -1]
 * 
 * ) -> x = 0 + 2 = 2 [1, -1] -> x = 2 + 1 = 3 [-1] -> x *= 2 = 6 [6]
 * 
 */
public class ScoreParentheses {
	static class TreeNode {
		TreeNode parent;
		List<TreeNode> children;
		
		TreeNode() {
			children = new ArrayList<>();
		}
		
		TreeNode(TreeNode parent) {
			this.parent = parent;
			children = new ArrayList<>();
		}
	}

	public int scoreParentheses(String s) {
		int ans = 0;
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(-1);
			}
			else { // ')'
				if (st.peek() == -1) {	// if it closes off an open parentheses, just exchange with 1 - terminal
					st.pop();
					st.push(1);
				}
				else {
					int x = 0;
					while (!st.isEmpty() && st.peek() != -1) { 	// Add up everything following condition 2 until we find the open parentheses
						x += st.pop();
					}
					st.pop();	// remove the open parentheses
					st.push(x * 2);	// multiply by 2 according to condition 3
				}
			}
		}
		
		// Add up computed substring scores
		while (!st.isEmpty()) {
			ans += st.pop();
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		ScoreParentheses sp = new ScoreParentheses();
		String s = "((()(()))((()))(()()))";
		
		System.out.println(sp.scoreParentheses(s));
	}

}
