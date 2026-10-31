class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element exists to the right
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push current element onto the stack for upcoming elements
            stack.push(arr[i]);
        }

        // Convert the result array to an ArrayList as required by the function
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : result) {
            list.add(val);
        }

        return list;
    }
}
