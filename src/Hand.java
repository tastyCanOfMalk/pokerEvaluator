import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Hand {

    private String[] hand;
    private ArrayList<Card> aHand = new ArrayList<Card>();


    public Hand(String hand){
        this.hand = hand.split(" ");
        for(String card : this.hand) aHand.add(new Card(card));
    }

    public ArrayList<String> getSuites(){
        ArrayList<String> suites = new ArrayList<String>();
        for(Card card : aHand) suites.add(card.getSuite());
        return suites;
    }

    public int getUniqueSuites(){
        HashSet a = new HashSet(this.getSuites());
        return a.size();
    }

    public ArrayList<String> getValues(){
        ArrayList<String> values = new ArrayList<String>();
        for(Card card : aHand) values.add(card.getValue());
        return values;
    }

    public ArrayList<Integer> getNumericValues(){
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(Card card : aHand) values.add(card.getNumericValue());
        Collections.sort(values);
        return values;
    }

    public int getUniqueNumericValues(){
        HashSet a = new HashSet(this.getNumericValues());
        return a.size();
    }

    public boolean mightBeStraight(){
        int h0 = this.getNumericValues().get(0);
        int h1 = this.getNumericValues().get(1);
        int h2 = this.getNumericValues().get(2);
        int h3 = this.getNumericValues().get(3);
        int h4 = this.getNumericValues().get(4);
        if(h0 + 1 == h1 &&
                h1 + 1 == h2 &&
                h2 + 1 == h3 &&
                h3 + 1 == h4) return true;
        else return false;

    }
    public boolean isStraightFlush(){
        if(this.mightBeStraight() &&
                // if straight one suite, then straight flush
                this.getUniqueSuites() == 1) return true;
        return false;
    }
    public boolean isStraight(){
        if(this.mightBeStraight() &&
                // if straight & not one suite, then straight
                this.getUniqueSuites() != 1) return true;
        else return false;
    }

    public boolean isFlush(){
        if(!this.mightBeStraight()
                // if not a straight & one suite, then flush
                && this.getUniqueSuites() == 1) return true;
        else return false;
    }

    public int getMaxUniqueCount(){
        HashSet handSet = new HashSet(this.getNumericValues());
        // convert hashSet to array to indexing
        ArrayList<Integer> arraySet = new ArrayList<Integer>(handSet);

        int a = 0;
        int b = 0;
        for(int x : this.getNumericValues()){
            if(x == arraySet.get(0)) a++;
            else if(x == arraySet.get(1)) b++;
        }
        return Math.max(a,b);
    }

    public boolean isFourKind(){
        if(this.getUniqueNumericValues() == 2
                && this.getMaxUniqueCount() == 4) return true;
        else return false;
    }

    public boolean isFullHouse(){
        if(this.getUniqueNumericValues() == 2
                && this.getMaxUniqueCount() == 3) return true;
        else return false;
    }

    public boolean isThreeKind(){
        if(this.getUniqueNumericValues() == 3
                && this.getMaxUniqueCount() == 3) return true;
        else return false;
    }

    public boolean isTwoPair(){
        if(this.getUniqueNumericValues() == 3
                && this.getMaxUniqueCount() == 2) return true;
        else return false;
    }

    public boolean isPair(){
        if(this.getUniqueNumericValues() == 4
                && this.getMaxUniqueCount() == 2) return true;
        else return false;
    }






    @Override
    public String toString() {
        return "Hand: \n" + aHand;
    }
}
