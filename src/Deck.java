public class Deck {
    private Card[] allCards;
    private Card[] hand;
    public Deck(boolean is) {
        if(is) {
            /* create 52 cards */
        }
        else {
            /* create 13 cards */

        }
    }
    public void swap(int first, int second) {
        Card temp = allCards[first];
        allCards[first] = allCards[second];
        allCards[second] = temp;
    }
    public void dealHand(int numCards){

    }
    public Card[] listhand() {
        return hand;
    }
    public void shuffleDeck() {

    }
}
