class Solution {

    private int n, cap;
    private int[] deliveries, pickups;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        this.cap = cap;
        this.n = n;
        this.deliveries = deliveries;
        this.pickups = pickups;

        long totalDistance = 0;

        int dIndex = n - 1;
        int pIndex = n - 1;

        while (dIndex >= 0 || pIndex >= 0) {
            dIndex = getFarthestIndex(deliveries, dIndex);
            pIndex = getFarthestIndex(pickups, pIndex);

            if (dIndex < 0 && pIndex < 0) break;

            totalDistance += calculateRoundDistance(dIndex, pIndex);

            processDeliveries(dIndex);
            processPickups(pIndex);
        }

        return totalDistance;
    }

    private int getFarthestIndex(int[] arr, int startIdx) {
        while (startIdx >= 0 && arr[startIdx] == 0) startIdx--;
        return startIdx;
    }

    private long calculateRoundDistance(int dIndex, int pIndex) {
        int farthest = Math.max(dIndex, pIndex);
        return 2L * (farthest + 1); // 배열 index → 거리, 왕복
    }

    private void processDeliveries(int dIndex) {
        int remainCap = cap;
        for (int i = dIndex; i >= 0 && remainCap > 0; i--) {
            if (deliveries[i] == 0) continue;

            int deliverNow = Math.min(deliveries[i], remainCap);
            deliveries[i] -= deliverNow;
            remainCap -= deliverNow;
        }
    }

    private void processPickups(int pIndex) {
        int remainCap = cap;
        for (int i = pIndex; i >= 0 && remainCap > 0; i--) {
            if (pickups[i] == 0) continue;

            int pickupNow = Math.min(pickups[i], remainCap);
            pickups[i] -= pickupNow;
            remainCap -= pickupNow;
        }
    }
}