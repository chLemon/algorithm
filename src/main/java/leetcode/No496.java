package leetcode;

import java.util.*;

class No496 {

    public static void main(String[] args) {
        No496 no = new No496();
        int[] arr = {137, 59, 92, 122, 52, 131, 79, 236, 94, 171, 141, 86, 169, 199, 248, 120, 196, 168, 77, 71, 5, 198, 215, 230, 176, 87, 189, 206, 115, 76, 13, 216, 197, 26, 183, 54, 250, 27, 109, 140, 147, 25, 96, 105, 30, 207, 241, 8, 217, 40, 0, 35, 221, 191, 83, 132, 9, 144, 12, 91, 175, 65, 170, 149, 174, 82, 102, 167, 62, 70, 44, 143, 10, 153, 160, 142, 188, 81, 146, 212, 15, 162, 103, 163, 123, 48, 245, 116, 192, 14, 211, 126, 63, 180, 88, 155, 224, 148, 134, 158, 119, 165, 130, 112, 166, 93, 125, 1, 11, 208, 150, 100, 106, 194, 124, 2, 184, 75, 113, 104, 18, 210, 202, 111, 84, 223, 173, 238, 41, 33, 154, 47, 244, 232, 249, 60, 164, 227, 253, 56, 157, 99, 179, 6, 203, 110, 127, 152, 252, 55, 185, 73, 67, 219, 22, 156, 118, 234, 37, 193, 90, 187, 181, 23, 220, 72, 255, 58, 204, 7, 107, 239, 42, 139, 159, 95, 45, 242, 145, 172, 209, 121, 24, 21, 218, 246, 49, 46, 243, 178, 64, 161, 117, 20, 214, 17, 114, 69, 182, 85, 229, 32, 129, 29, 226, 136, 39, 36, 233, 43, 240, 254, 57, 251, 78, 51, 195, 98, 205, 108, 61, 66, 16, 213, 19, 68, 237, 190, 3, 200, 133, 80, 177, 97, 74, 138, 38, 235, 135, 186, 89, 201, 4, 101, 151, 31, 228, 231, 34, 225, 28, 222, 128, 53, 50, 247};
        int[] ints = no.nextGreaterElement(arr, arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 这里可以不用map处理arr2，可以用map先记录arr1，然后在遍历arr2的时候填答案
        
        Map<Integer, Integer> value2IndexInArr2 = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] valueNBIndexInArr2 = new int[nums2.length];

        for (int i = 0; i < nums2.length; i++) {
            value2IndexInArr2.put(nums2[i], i);

            if (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    valueNBIndexInArr2[stack.pop()] = i;
                }
            }
            stack.push(i);
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums1.length; i++) {
            int indexInArr2 = value2IndexInArr2.get(nums1[i]);
            int nextBiggerIndex = valueNBIndexInArr2[indexInArr2];
            if (nextBiggerIndex != 0) res[i] = nums2[nextBiggerIndex];
        }
        return res;
    }

}
