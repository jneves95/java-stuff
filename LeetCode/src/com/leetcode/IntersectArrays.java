import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectArrays {

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> intersection = new ArrayList<Integer>();
		
		int i = 0;
		int j = 0;
		
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				intersection.add(nums1[i]);
				i++;
				j++;
			}
			else if (nums1[i] > nums2[j]) j++;
			else i++;
		}
		
		int[] result = new int[intersection.size()];
		for (int k = 0; k < result.length; k++) 
			result[k] = intersection.get(k);
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] example1 = new int[] {2, 1, 2, 3, 4, 0, 5, 4, 3, 3};
		int[] example2 = new int[] {3, 2, 3, 2, 1, 1, 6};
		
		IntersectArrays ia = new IntersectArrays();
		
		int[] result = ia.intersect(example1, example2);
		
		for (int i : result)
			System.out.println(i);
	}

}
