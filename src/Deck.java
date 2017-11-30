import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;
import java.util.Arrays;
public class Deck {
    public Card[] allCards = new Card[52];
    private Card[] hand;
    public Deck(boolean is) {
        int count = 0;
        if(is) {
            for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 13; j++) {
                    if (j <= 10 && j > 1) {
                        String n = Integer.toString(j);
                        allCards[count] = new Card(i, j, n);
                        count += 1;
                    } else if (j == 1) {
                        allCards[count] = new Card(i, j,"ace");
                        count += 1;
                    } else if (j == 11) {
                        allCards[count] = new Card(i, j,"jack");
                        count += 1;
                    } else if (j == 12) {
                        allCards[count] = new Card(i, j, "queen");
                        count += 1;
                    } else if (j == 13){
                        allCards[count] = new Card(i, j, "king");
                        count += 1;
                    }
                }
            }
        }
        else{
            for (int j = 1; j <= 13; j++) {
                int i = ThreadLocalRandom.current().nextInt(1, 5);
                if (j <= 10 && j > 1) {
                    String n = Integer.toString(j);
                    allCards[count] = new Card(i, j, n);
                    count += 1;
                } else if (j == 1) {
                    allCards[count] = new Card(i, j,"ace");
                    count += 1;
                } else if (j == 11) {
                    allCards[count] = new Card(i, j,"jack");
                    count += 1;
                } else if (j == 12) {
                    allCards[count] = new Card(i, j, "queen");
                    count += 1;
                } else if (j == 13) {
                    allCards[count] = new Card(i, j, "king");
                    count += 1;
                }
            }
        }
    }

    private void swap(int first, int second) {
        Card temp = hand[first];
        hand[first] = hand[second];
        hand[second] = temp;
    }

    public void dealHand(int numCards){
        hand = new Card[numCards];
        int len = 0;
        while(len < numCards) {
            hand[len] = allCards[len];
            len += 1;
        }
        for(int i = 0; i < hand.length; i++){
            System.out.print(hand[i].getName() + " ");
        }
    }

    public Card[] listHand() {
        String names;
        for(int i = 0; i < hand.length; i++){
             System.out.print(hand[i].getName() + " ");
        }
        return hand;
    }

    public void shuffleDeck() {
        Collections.shuffle(Arrays.asList(allCards));
    }

    public void bubbleSortHand() {
        for(int j = 0; j < hand.length - 1; j++) {
            for (int i = 0; i < hand.length - 1; i++) {
                if (hand[i].getValue() > hand[i + 1].getValue()) {
                    swap(i, i + 1);
                }
            }
        }
    }
    public void selectionSortHand() {
        int n = hand.length;
        for (int i = 0; i < n-1; i++) {
            int lowest = i;
            for (int j = i+1; j < n; j++) {
                if (hand[j].getValue() < hand[lowest].getValue()) {
                    lowest = j;
                }
            }
            swap(lowest, i);
        }
    }
    public void mergeSortHand() {
        sort(hand);
    }
    private static void sort(Card[] input) {
        if(input.length > 1) {
            // split the array into two pieces, as close to the same
            // size as possible.
            Card[] first = extract(input, 0, input.length / 2);
            Card[] last = extract(input, input.length / 2, input.length);

            // sort each of the two halves recursively
            sort(first);
            sort(last);

            // merge the two sorted halves together
            merge(input, first, last);
        }
    }
    private static Card[] extract(Card[] input, int start, int last) {
        Card[] ret = new Card[last - start];
        for(int i = 0; i < ret.length; i++) { ret[i] = input[start + i]; }
        return ret;
    }
    private static void merge(Card[] dest, Card[] a, Card[] b) {
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length) {
            if(a[i].getValue() < b[j].getValue()) {
                dest[i + j] = a[i];
                ++i;
            } else {
                dest[i + j] = b[j];
                ++j;
            }
        }
        for(; i < a.length; i++) dest[i + j] = a[i];
        for(; j < b.length; j++) dest[i + j] = b[j];
    }
    public Card binarySearch(Card[] sortedArray, int key, int low, int high) {
        int middle = (low + high) / 2;
        if (high < low) {
            return new Card(0, -1, "Does Not Exist");
        }
        if (key == sortedArray[middle].getValue()) {
            return sortedArray[middle];
        } else if (key < sortedArray[middle].getValue()) {
            return binarySearch(sortedArray, key, low, middle - 1);
        } else {
            return binarySearch(sortedArray, key, middle + 1, high);
        }
    }
}
