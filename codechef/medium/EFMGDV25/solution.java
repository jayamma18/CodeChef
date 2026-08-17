import java.util.ArrayList;

class BooleanCounter {

    public static void main(String[] args) {
        ArrayList<Boolean> booleanList = new ArrayList<>();
        booleanList.add(true);
        booleanList.add(false);
        booleanList.add(true);
        booleanList.add(true);
        booleanList.add(false);

        int trueCount = countTrueValues(booleanList);
        System.out.println("Number of true values: " + trueCount);
    }

    public static int countTrueValues(ArrayList<Boolean> list) {
        int count = 0;
        for (Boolean b : list) {
            if (b) {
                count++;
            }
        }
        return count;
    }
}