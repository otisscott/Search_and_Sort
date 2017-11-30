public class Card {
    private int suit;
    private int value;
    private String name;
    public Card(int s, int v, String n) {
        name = n;
        suit = s;
        value = v;
    }
    public int getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
    public int getSuit() {
        return suit;
    }
}
