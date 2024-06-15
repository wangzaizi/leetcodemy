package com.mxx.bootleetcode.demo;

public class FindMedianSortedArrays {
    //给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -10⁶ <= nums1[i], nums2[i] <= 10⁶
//
//
// Related Topics 数组 二分查找 分治 👍 7147 👎 0

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 寻找两个有序数组的中位数。
     * 通过将两个数组合并成一个新数组，并对新数组进行排序来找到中位数。
     * 如果新数组的长度是偶数，则中位数是中间两个数的平均值；如果是奇数，则中位数是中间的数。
     *
     * @param nums1 第一个有序数组
     * @param nums2 第二个有序数组
     * @return 两个有序数组的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 计算两个数组的长度
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 计算合并后数组的长度
        int len = len1 + len2;
        // 创建一个新数组，用于存放两个数组合并后的元素
        int[] nums = new int[len];
        // 初始化三个指针，分别指向nums1、nums2和nums的起始位置
        int i = 0, j = 0, k = 0;
        // 遍历两个数组，将较小的元素放入新数组
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        // 处理第一个数组剩余的元素
        while (i < len1) {
            nums[k++] = nums1[i++];
        }
        // 处理第二个数组剩余的元素
        while (j < len2) {
            nums[k++] = nums2[j++];
        }
        // 根据新数组的长度计算中位数
        if (len % 2 == 0) {
            // 如果长度是偶数，返回中间两个数的平均值
            return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
        } else {
            // 如果长度是奇数，返回中间的数
            return nums[len / 2];
        }
    }
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // 初始化新数组为原来的两个数组之和
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] nums = new int[len];
        // 初始化3个指针分别指向 nums1 nums2 nums
        int i = 0, j = 0, k = 0;
        while (i < len1 && j <len2){
            if (nums1[i] < nums2[j]){
                nums[k++]= nums1[i++];
            }else{
                nums[k++] = nums2[j++];
            }
        }
        while (i < len1){
            nums[k++] = nums1[i++];
        }
        while (j < len2){
            nums[k++] = nums2[j++];
        }
        if (len % 2 == 0){
            return (nums[len/2-1]+nums[len/2])/2.0;
        }else{
            return nums[len/2];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

//leetcode submit region end(Prohibit modification and deletion)

}
