package binaryway;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class leetcode_215 {
    // 三路快排
    private int quickSelect(List<Integer> nums,int k){
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));

        // 将大于小于等于pivot的元素划分至三个列表中
        List<Integer> big = new ArrayList();
        List<Integer> equal = new ArrayList();
        List<Integer> small = new ArrayList();
        for(int num :nums){
            if(num > pivot)
                big.add(num);
            else if(num < pivot)
                small.add(num);
            else
                equal.add(num);
        }
        // 第 k 大元素在 big 中，递归划分
        if (k <= big.size())
            return quickSelect(big, k);
        // 第 k 大元素在 small 中，递归划分
        if (k> big.size()+equal.size())
            return quickSelect(small, k - nums.size() + small.size());
        // 第 k 大元素在 equal 中，直接返回 pivot
        return pivot;
    }




    public int findKthLargest(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for(int num : nums) {
            numList.add(num);
        }
        return quickSelect(numList,k);
    }



    // 双路快排
    public int findKthLargest(int[] nums, int k) {
        // 快速排序
        int low = 0;
        int high = nums.length - 1;
        quickSort(nums,low,high);
        return nums[nums.length - k];
    }
    public void quickSort(int[] nums , int low , int high){
        if(low < high){
            int position = partion( nums, low , high);
            quickSort(nums , low , position - 1);
            quickSort( nums , position + 1  ,  high);
        }
    }
    public int partion(int[] nums,int low , int high){
        int pivot = nums[high];
        // pointer 为第二指针 最终交换位置
        int pointer = low;
        for(int i = low ; i < high ;i ++){
            if(nums[i] < pivot){
                int tmp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = tmp;
            }
        }
        // 交换第二指针和pivot
        int tmp = nums[pointer];
        nums[pointer] = nums[high];
        nums[high] = tmp;
        // 返回下标索引
        return pointer;
    }
}
