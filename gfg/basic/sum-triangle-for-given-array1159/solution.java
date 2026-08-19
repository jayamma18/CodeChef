class Solution {
	public ArrayList<Integer> getTriangle(int[] arr) {
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> current = new ArrayList<>();
		for (int x : arr)
			current.add(x);
		ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
		rows.add(new ArrayList<>(current));
		while (current.size() > 1) {
			ArrayList<Integer> next = new ArrayList<>();
			for (int i = 0; i < current.size() - 1; i++)
				next.add(current.get(i) + current.get(i + 1));
			current = next;
			rows.add(new ArrayList<>(current));
		}
		for (int i = rows.size() - 1; i >= 0; i--)
			result.addAll(rows.get(i));
		return result;
	}
}
