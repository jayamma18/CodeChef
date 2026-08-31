import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Codechef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // Read number of test cases
        if (!br.ready()) return;
        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            // Sort the array
            Arrays.sort(a);

            // Construct the rearranged array
            int[] ans = new int[n];
            int left = 0, right = n - 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    ans[i] = a[left++];
                } else {
                    ans[i] = a[right--];
                }
            }

            // Append the result for the current test case
            for (int i = 0; i < n; i++) {
                out.append(ans[i]).append(i == n - 1 ? "" : " ");
            }
            out.append("\n");
        }
        
        // Print all outputs at once for faster I/O
        System.out.print(out);
    }
}