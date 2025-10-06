import java.util.*;

class Solution {
    int target;
    int coin;
    
    public boolean canProgressFirstCase(Set<Integer> currentDeck) {
        for(int i : currentDeck) {
            if(currentDeck.contains(target - i) && (target - i != i)) {
                currentDeck.remove(i);
                currentDeck.remove(target - i);
                return true;
            }
        }
        return false;
    }
    
    public boolean canProgressSecondCase(Set<Integer> currentDeck, Set<Integer> newCardDeck) {
        for(int i : newCardDeck) {
            if(currentDeck.contains(target - i)) {
                currentDeck.remove(target - i);
                newCardDeck.remove(i);
                this.coin--;
                return true;
            }
        }
        return false;
    }
    
    public boolean canProgressThirdCase(Set<Integer> newCardDeck) {
        for(int i : newCardDeck) {
            if(newCardDeck.contains(target - i) && (target - i != i)) {
                newCardDeck.remove(target - i);
                newCardDeck.remove(i);
                this.coin-=2;
                return true;
            }
        }
        return false;
    }
    
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        this.target = n+1;
        this.coin = coin;
        
        Set<Integer> currentDeck = new HashSet<>();
        Set<Integer> newCardDeck = new HashSet<>();
        
        for(int i = 0; i < n/3; i++) {
            currentDeck.add(cards[i]);
        }
        
        int curRnd = 0;
        int idx = n/3;
        
        while(idx < n) {
            // New cards to get for current rnd
            int firstCard = cards[idx++];
            int secondCard = (idx < n)? cards[idx++] : -1;
            
            boolean flag = false;
            
            newCardDeck.add(firstCard);
            newCardDeck.add(secondCard);
            
            // First scenario : When there is a pair that matches n+1 with the currentDeck only
            if(canProgressFirstCase(currentDeck)) {
                curRnd++;
                continue;
            } else if (this.coin >= 1 && canProgressSecondCase(currentDeck, newCardDeck)){
                curRnd++;
            } else if(this.coin >= 2 && canProgressThirdCase(newCardDeck)) {
                curRnd++;
            } else {
                // No case
                break;
            }
        }
        
        return curRnd+1;
    }
}