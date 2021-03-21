import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the right-most values 
 * ordered from top to bottom, as if we were standing on the right side of the tree.
 * 
 * We do this by recursively evaluating the left and right subtrees for their own right-most 
 * array, and overlap those arrays, prioritizing the right subtree array, and then adding this 
 * node's value to the beginning of the resulting array.
 * Example: val = 6, left = [0, 1, 2, 3], right = [4, 5] -> returns [6, 4, 5, 2, 3]
 * 
 */
public class RightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) return new ArrayList<Integer>();
		
		List<Integer> right = rightSideView(root.right);
		List<Integer> left = rightSideView(root.left);

		List<Integer> result = right;
		for (int i = right.size(); i < left.size(); i++) {
			result.add(left.get(i));
		}
		
		result.add(0, root.val);

		return result;
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(5);
		TreeNode c = new TreeNode(15);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(7);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(17);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		d.right = f;
		c.right = g;
		
		RightSideView rsv = new RightSideView();
		List<Integer> result = rsv.rightSideView(new TreeNode());
		
		for (int i : result)
			System.out.println(i);
		
	}

}
