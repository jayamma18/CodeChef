import java.util.*;

class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 1;
        int j = 0;
        int platforms = 1;
        int maxPlatforms = 1;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }
}