public static String sortByFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        List<Character> chars = new ArrayList<>(freq.keySet());
        Collections.sort(chars, (a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);
            if (fa != fb) {
                return fb - fa; // higher frequency first
            }
            return a - b; // lexicographical order if equal frequency
        });

        // Build result string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            int count = freq.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
