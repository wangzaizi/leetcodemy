package com.mxx.bootleetcode.demo;

import java.util.ArrayList;
import java.util.Arrays;
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
        // 排序
        Arrays.sort(nums);
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


        return res;
    }
    /**
     * 寻找数组中的四元组，这些四元组的和等于给定的目标值。
     *
     * @param nums 输入的整数数组
     * @param target 目标和
     * @return 返回一个列表，包含所有和为目标值的四元组
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 检查数组是否为空或长度是否小于4
        if (nums == null || nums.length < 4) {
            return res;
        }
        int len = nums.length;
        // 对数组进行排序，以便后续使用双指针技术
        // 排序
        Arrays.sort(nums);
        // 遍历数组，固定第一个元素
        // 固定第一个a的位置
        for (int a = 0; a < len - 3; a++) {
            // 跳过重复的元素，以避免产生重复的四元组
            // 跳过重复的数字，避免重复的四元组
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // 遍历数组，固定第二个元素
            for (int b = a + 1; b < len - 2; b++) {
                // 跳过重复的元素
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 使用双指针，一个从左开始，一个从右开始
                // 定义双指针 处理剩余的数组
                for (int c = b + 1, d = len - 1; c < d;) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    // 如果四个元素的和等于目标值
                    if (sum == target) {
                        res.add(new ArrayList<>(List.of(nums[a], nums[b], nums[c], nums[d])));
                        // 跳过重复的元素，以避免产生重复的四元组
                        // 跳过重复的数字，避免重复的四元组
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        // 移动指针，继续寻找下一个可能的四元组
                        // 移动c和d的位置
                        c++;
                        d--;
                    } else if (sum < target) {
                        // 如果四个元素的和小于目标值，移动左指针，使得和变大
                        c++;
                    } else {
                        // 如果四个元素的和大于目标值，移动右指针，使得和变小
                        d--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 检查数组是否为空或长度是否小于4
        if (nums == null || nums.length < 4) {
            return res;
        }
        int len = nums.length;
        // 对数组进行排序，以便后续使用双指针技术
        // 排序
        Arrays.sort(nums);
        // 遍历数组，固定第一个元素
        // 固定第一个a的位置
        for (int a = 0; a < len - 3; a++) {
            // 跳过重复的元素，以避免产生重复的四元组
            // 跳过重复的数字，避免重复的四元组
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // 遍历数组，固定第二个元素


        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        FourSumDemo fourSumDemo = new FourSumDemo();
        List<List<Integer>> res = fourSumDemo.fourSum(nums, target);
        System.out.println(res);
    }
}
