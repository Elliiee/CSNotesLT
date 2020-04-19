public class _485MaxConsecutive1s {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int i : nums){
            cur = i == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
