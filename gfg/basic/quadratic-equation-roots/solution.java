
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> roots = new ArrayList<>();

        // Calculate the discriminant
        double discriminant = (double) b * b - 4.0 * a * c;

        // If discriminant is negative, roots are imaginary
        if (discriminant < 0) {
            roots.add(-1);
            return roots;
        }

        // Calculate both real roots
        double root1 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2.0 * a);

        // Take the floor value of both roots
        int r1 = (int) Math.floor(root1);
        int r2 = (int) Math.floor(root2);

        // Return in decreasing order
        roots.add(Math.max(r1, r2));
        roots.add(Math.min(r1, r2));

        return roots;
    }
}
