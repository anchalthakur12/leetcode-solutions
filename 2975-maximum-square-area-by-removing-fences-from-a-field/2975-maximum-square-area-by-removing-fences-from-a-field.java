class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1000000007;

        // Step 1: store all horizontal fence positions (including boundaries)
        ArrayList<Integer> h = new ArrayList<>();
        h.add(1);
        h.add(m);
        for (int i = 0; i < hFences.length; i++) {
            h.add(hFences[i]);
        }

        // Step 2: store all vertical fence positions (including boundaries)
        ArrayList<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(n);
        for (int i = 0; i < vFences.length; i++) {
            v.add(vFences[i]);
        }

        // Step 3: sort fence positions
        Collections.sort(h);
        Collections.sort(v);

        // Step 4: store all possible horizontal gaps
        HashSet<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                hGaps.add(h.get(j) - h.get(i));
            }
        }

        // Step 5: find largest common gap
        int maxSide = 0;
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                int gap = v.get(j) - v.get(i);
                if (hGaps.contains(gap)) {
                    maxSide = Math.max(maxSide, gap);
                }
            }
        }

        // Step 6: return result
        if (maxSide == 0) {
            return -1;
        }

        long area = (long) maxSide * maxSide;
        return (int) (area % MOD);
    }
}
