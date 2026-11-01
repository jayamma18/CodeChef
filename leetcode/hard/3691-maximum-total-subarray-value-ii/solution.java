import java.util.*;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Binary search for the threshold value V
        int low = 0, high = 1_000_000_000;
        int V = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countGreaterEqual(nums, mid) >= k) {
                V = mid;
                low = mid + 1; // Try to find a larger minimum value
            } else {
                high = mid - 1;
            }
        }
        
        // Step 2: Accumulate all subarrays with value >= V + 1
        long totalSum = 0;
        int ansCnt = 0;
        int targetV = V + 1;
        
        int r = 0;
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        
        for (int l = 0; l < n; l++) {
            while (r < n) {
                while (!maxDq.isEmpty() && nums[maxDq.peekLast()] <= nums[r]) maxDq.pollLast();
                while (!minDq.isEmpty() && nums[minDq.peekLast()] >= nums[r]) minDq.pollLast();
                maxDq.addLast(r);
                minDq.addLast(r);
                
                int curMax = nums[maxDq.peekFirst()];
                int curMin = nums[minDq.peekFirst()];
                
                if (curMax - curMin >= targetV) {
                    break; 
                }
                r++;
            }
            
            if (r < n) {
                // All subarrays from r' = r to n-1 have value >= V + 1
                int curMax = nums[maxDq.peekFirst()];
                int curMin = nums[minDq.peekFirst()];
                
                for (int rPrime = r; rPrime < n; rPrime++) {
                    curMax = Math.max(curMax, nums[rPrime]);
                    curMin = Math.min(curMin, nums[rPrime]);
                    totalSum += (curMax - curMin);
                    ansCnt++;
                }
            }
            
            // Clean deques for next left boundary
            if (!maxDq.isEmpty() && maxDq.peekFirst() == l) maxDq.pollFirst();
            if (!minDq.isEmpty() && minDq.peekFirst() == l) minDq.pollFirst();
            if (r == l) r++;
        }
        
        // Step 3: Top off the remaining subarrays up to k using value V
        if (ansCnt < k) {
            totalSum += (long) (k - ansCnt) * V;
        }
        
        return totalSum;
    }
    
    // Counts how many subarrays have max - min >= V in O(N) time
    private long countGreaterEqual(int[] nums, int V) {
        if (V <= 0) {
            long n = nums.length;
            return n * (n + 1) / 2;
        }
        
        int n = nums.length;
        long cnt = 0;
        int r = 0;
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        
        for (int l = 0; l < n; l++) {
            while (r < n) {
                while (!maxDq.isEmpty() && nums[maxDq.peekLast()] <= nums[r]) maxDq.pollLast();
                while (!minDq.isEmpty() && nums[minDq.peekLast()] >= nums[r]) minDq.pollLast();
                maxDq.addLast(r);
                minDq.addLast(r);
                
                int curMax = nums[maxDq.peekFirst()];
                int curMin = nums[minDq.peekFirst()];
                
                if (curMax - curMin >= V) {
                    break;
                }
                r++;
            }
            
            if (r < n) {
                cnt += (n - r);
            }
            
            if (!maxDq.isEmpty() && maxDq.peekFirst() == l) maxDq.pollFirst();
            if (!minDq.isEmpty() && minDq.peekFirst() == l) minDq.pollFirst();
            if (r == l) r++;
        }
        
        return cnt;
    }
}
