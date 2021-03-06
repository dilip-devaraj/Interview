package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums==null || nums.length==0) return res;
		boolean[] used = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, used, list, res);
		Set<List<Integer>> setList = new LinkedHashSet<>(res);
		List<List<Integer>> res2 = new ArrayList<>(setList);
		return res2;
	}

	public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
		if(list.size()==nums.length){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(used[i]) continue;
		//	if(i>0 && nums[i-1]==nums[i] && !used[i-1]) continue;
			used[i]=true;
			list.add(nums[i]);
			dfs(nums,used,list,res);
			used[i]=false;
			list.remove(list.size()-1);
		}
	}
	
	public static void main(String[] args) {
		PermutationsII permuation = new PermutationsII();
		int[] nums = {1,3,3};
		List<List<Integer>>  lists = permuation.permuteUnique(nums);
		for(List<Integer> list: lists) {
			System.out.println(list);
		}
	}
}
