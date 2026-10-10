/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    private int findByBinarySearchIncreasing(int low, int high, MountainArray mountainArr, int target) {
        while(low <= high) {
            int mid = (low + high)/2;
            if(mountainArr.get(mid) == target) {
                return mid;
            } 

            if(mountainArr.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findByBinarySearchDecreasing(int low, int high, MountainArray mountainArr, int target) {
        while(low <= high) {
            int mid = (low + high)/2;
            if(mountainArr.get(mid) == target) {
                return mid;
            } 

            if(mountainArr.get(mid) < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int n = mountainArr.length();
        int low = 1, high = n-2;
        int peakIndex = -1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid-1) &&
               mountainArr.get(mid) > mountainArr.get(mid + 1)) {

                peakIndex = mid;
                break;
            }

            if(mountainArr.get(mid-1) < mountainArr.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(target == mountainArr.get(peakIndex)) {
            return peakIndex;
        }

        int targetIndex = -1;

        targetIndex = findByBinarySearchIncreasing(0, peakIndex - 1, mountainArr, target);

        if(targetIndex == -1) {
            targetIndex = findByBinarySearchDecreasing(peakIndex + 1, n - 1, mountainArr, target);
        }

        return targetIndex;

    }
}