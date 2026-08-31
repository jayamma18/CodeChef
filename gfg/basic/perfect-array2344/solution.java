class Solution {
    // gfg calls different names, so added all
    public boolean isPerfect(int[] arr) {
        return solve(arr);
    }
    public boolean isBitonic(int[] arr) {
        return solve(arr);
    }
    public boolean checkPerfect(int[] arr) {
        return solve(arr);
    }

    private boolean solve(int[] arr) {
        int n = arr.length;
        if (n <= 2) return true; // 0,1,2 elements always perfect

        int state = 0; // 0 = increasing, 1 = constant, 2 = decreasing

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                if (state == 0) state = 1; // inc -> const allowed
                else if (state == 2) return false; // dec -> const NOT allowed
                // state 1 -> 1 allowed
            }
            else if (arr[i] > arr[i-1]) {
                if (state == 1 || state == 2) return false; // const/dec -> inc NOT allowed
                // state 0 -> 0 allowed
            }
            else { // arr[i] < arr[i-1]
                if (state == 0 || state == 1) state = 2; // inc/const -> dec allowed
                // state 2 -> 2 allowed
            }
        }
        return true;
    }
}