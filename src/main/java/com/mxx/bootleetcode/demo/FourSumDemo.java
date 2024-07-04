package com.mxx.bootleetcode.demo;

import java.util.ArrayList;
import java.util.List;

public class FourSumDemo {
    //给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
    // 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
    // （若两个四元组元素一一对应，则认为两个四元组重复）：
    //
    //0 <= a, b, c, d < n
    //a、b、c 和 d 互不相同
    //nums[a] + nums[b] + nums[c] + nums[d] == target
    //你可以按 任意顺序 返回答案 。
    //
    //示例 1：
    //
    //输入：nums = [1,0,-1,0,-2,2], target = 0
    //输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    //示例 2：
    //
    //输入：nums = [2,2,2,2,2], target = 8
    //输出：[[2,2,2,2]]
    //提示：
    //
    //1 <= nums.length <= 200
    //-109 <= nums[i] <= 109
    //-109 <= target <= 109
    //Related Topics
    //数组
    //双指针
    //排序
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return res;
        }
        int len = nums.length;
        // 固定第一个a的位置
        for (int a = 0 ;a <len - 3 ;a++){
            // 跳过重复的数字，避免重复的四元组
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < len - 2; b++){
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 定义双指针 处理剩余的数组
                for (int c = b + 1, d = len - 1; c < d;){
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target){
                        res.add(new ArrayList<>(List.of(nums[a], nums[b], nums[c], nums[d])));
                        // 跳过重复的数字，避免重复的四元组
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                       }
                        // 移动c和d的位置
                        c++;
                        d--;
                    }else if (sum < target) {
                    c++;
                } else {
                    d--;
                }
            }
            }
        }


        return null;
    }
}
