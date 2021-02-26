package leetcode;

public class No198 {
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if (nums.length==1){
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length==2){
            return dp[1];
        }
        dp[2] = Math.max(nums[0] + nums[2], nums[1]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length-1];
    }
    /*
    if (nums.size() == 0) {
        return 0;
    }
    int N = nums.size();
    vector<int> dp(N+1, 0);
    dp[0] = 0;
    dp[1] = nums[0];
    for (int k = 2; k <= N; k++) {
        dp[k] = max(dp[k-1], nums[k-1] + dp[k-2]);
    }
    return dp[N];
     */
}
