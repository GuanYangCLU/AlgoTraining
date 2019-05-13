class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i=0;i<nums.length;i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                int rs[] = new int[]{map.get(nums[i]), i};
                return(rs);
            }
        }
        return(new int[]{});
    }
}

