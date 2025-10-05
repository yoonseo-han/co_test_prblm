import java.util.*;

class Solution {
    
    int n;
    int[] cards;
    int target;
    Map<String, Integer> storeMaxRound;
    
    public int solution(int coin, int[] cards) {
        this.n = cards.length;
        this.cards = cards;
        this.target = n + 1;
        this.storeMaxRound = new HashMap<>();
        
        int initialCardMask = 0;
        for(int i=0; i < n/3; i++) {
            // Implement binary for the following
            initialCardMask |= (1 << i);
        }
        
        return dfs(n/3, coin, initialCardMask);
    }
    
    // idx: Current card to consider
    // coin: Num of coins remaining
    // cardMask: current card deck being used
    public int dfs(int idx, int coin, int cardDeck) {
        // Base case: When consider all possible cards
        if(idx >= n) return 0;
        
        // If previously already dealt -> return following value immediately
        String key = idx + "," + coin + "," + cardDeck;
        if(storeMaxRound.containsKey(key)) return storeMaxRound.get(key);
        
        // Add the new 2 cards
        int newDeck = cardDeck;
        if(idx < n) newDeck |= (1 << idx);
        if(idx < n+1) newDeck |= (1 << idx+1);

        int maxRound = 0;
        
        List<int[]> possiblePairs = generatePossiblePairs(newDeck);
        
        for (int[] curPair: possiblePairs) {
            // Consider generating all possible pairs from this
            
            // Mark the current pair as used
            int useMask = (1 << curPair[0]) | (1 << curPair[1]);
            int coinUsed = 0;
            
            if(curPair[0] >= n/3) coinUsed++;
            if(curPair[1] >= n/3) coinUsed++;
            
            // Cant use current pair then
            if(coinUsed > coin) continue;
            
            int afterDeck = newDeck & (~useMask);
            
            maxRound = Math.max(maxRound, 1 + dfs(idx + 2, coin - coinUsed, afterDeck));
        }
        
        storeMaxRound.put(key, maxRound);
        return maxRound;
    }
    
    public List<int[]> generatePossiblePairs(int newDeck) {
        List<int[]> result = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            // Doesnt have the ith card
            if((newDeck & (1 << i)) == 0) continue;
            for(int j = i+1; j<n; j++) {
                // Doesnt have the jth card
                if((newDeck & (1 << j)) == 0) continue;
                if(cards[i] + cards[j] == target) {
                    result.add(new int[]{i, j});
                }
            }
        }
        
        return result;
    }
}