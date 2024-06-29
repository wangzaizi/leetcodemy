package com.mxx.bootleetcode.demo;

import java.util.Arrays;

public class ThreeSumClosestDemo {
    //给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
    //
    //返回这三个数的和。
    //
    //假定每组输入只存在恰好一个解。
    //
    //示例 1：
    //
    //输入：nums = [-1,2,1,-4], target = 1
    //输出：2
    //解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
    //示例 2：
    //
    //输入：nums = [0,0,0], target = 1
    //输出：0
    //提示：
    //
    //3 <= nums.length <= 1000
    //-1000 <= nums[i] <= 1000
    //-104 <= target <= 104
    //Related Topics
    //数组
    //双指针
    //排序
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        ThreeSumClosestDemo threeSumClosestDemo = new ThreeSumClosestDemo();
        System.out.println(threeSumClosestDemo.threeSumClosest(nums,target));
    }
}
