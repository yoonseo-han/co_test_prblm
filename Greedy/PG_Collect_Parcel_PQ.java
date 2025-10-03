package Greedy;

import java.util.*;

class Parcel implements Comparable<Parcel>{
    int houseIndex;
    int pickupCnt;
    int deliverCnt;
    
    Parcel(int houseIndex, int pickupCnt, int deliverCnt) {
        this.houseIndex = houseIndex;
        this.pickupCnt = pickupCnt;
        this.deliverCnt = deliverCnt;
    }
    
    @Override
    public int compareTo(Parcel o) {
        return this.houseIndex - o.houseIndex;
    }

    public boolean hasPickup() {
        return (this.pickupCnt > 0) ? true : false;
    }
    
    public boolean hasDeliver() {
        return (this.deliverCnt > 0) ? true : false;
    }
}

class Solution {
    public long roundTrip(int cap, PriorityQueue<Parcel> storeParcel) {
        List<Parcel> putback = new ArrayList<>();
        long distance = (long) storeParcel.peek().houseIndex;
        int remainingPickup = cap;
        int remainingDelivery = cap;
        
        while((remainingPickup > 0 || remainingDelivery > 0) && !storeParcel.isEmpty()){
            Parcel curParcel = storeParcel.poll();
            
            int removePickup = Math.min(curParcel.pickupCnt, remainingPickup);
            int removeDelivery = Math.min(curParcel.deliverCnt, remainingDelivery);
            
            curParcel.pickupCnt -= removePickup;
            curParcel.deliverCnt -= removeDelivery;

            remainingPickup -= removePickup;
            remainingDelivery -= removeDelivery;
            
            if(curParcel.hasPickup() || curParcel.hasDeliver()) {
                putback.add(curParcel);
            }
        }
        
        for (Parcel curParcel : putback) {
            storeParcel.add(curParcel);
        }
        
        return distance*2;
    }
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        PriorityQueue<Parcel> storeParcel = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++) {
            int idx = i+1;
            Parcel tempParcel = new Parcel(idx, pickups[i], deliveries[i]);
            storeParcel.add(tempParcel);
        }
        
        while(!storeParcel.isEmpty()) {
            answer += roundTrip(cap, storeParcel);
        }
        
        return answer;
    }
}