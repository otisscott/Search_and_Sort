public class Runner {
    public static void main(String[] args) {
        Deck d = new Deck(true);
        d.shuffleDeck();
        d.dealHand(7);
        d.listHand();
        d.binarySearch(d.listHand(), 4, 0, d.listHand().length - 1);
    }
}

