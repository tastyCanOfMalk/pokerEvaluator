import java.util.ArrayList;
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

//    public ArrayList<String> getValues(){
//        ArrayList<String> values = new ArrayList<String>();
//        for(Card card : aHand) values.add(card.getValue());
//        return values;
//    }

    public ArrayList<Integer> getNumericValues(){
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(Card card : aHand) values.add(card.getNumericValue());
        Collections.sort(values);
        return values;
    }

    public ArrayList<Integer> getNumericValuesForScoring(){
        // converts Ace to 14 instead of 1
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(Card card : aHand){
            if (card.getNumericValue() == 1){
                values.add(14);
            } else values.add(card.getNumericValue());
        }
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
        int c = 0;
        int d = 0;
        for(int x : this.getNumericValues()){
            if(arraySet.size() == 1){
                if(x == arraySet.get(0)) a++;
            }
            else if(arraySet.size() == 2){
                if(x == arraySet.get(0)) a++;
                if(x == arraySet.get(1)) b++;
            }
            else if(arraySet.size() == 3) {
                if(x == arraySet.get(0)) a++;
                if(x == arraySet.get(1)) b++;
                if(x == arraySet.get(2)) c++;
            }
            else if(arraySet.size() == 4) {
                if(x == arraySet.get(0)) a++;
                if(x == arraySet.get(1)) b++;
                if(x == arraySet.get(2)) c++;
                if(x == arraySet.get(3)) d++;
            }
        }
        return Math.max(Math.max(Math.max(a,b),c),d);
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

    public String getHighCard(){
        int tempMax = Collections.max(this.getNumericValues());
        if(this.getNumericValues().contains(1)) return "Ace";
        else if (tempMax == 13) return "King";
        else if (tempMax == 12) return "Queen";
        else if (tempMax == 11) return "Jack";
        else return Integer.toString(tempMax);
    }

    public int getHighCardValue(){
        int tempMax = Collections.max(this.getNumericValues());
        if(this.getNumericValues().contains(1)) return 14;
        else if (tempMax == 13) return 13;
        else if (tempMax == 12) return 12;
        else if (tempMax == 11) return 11;
        else return tempMax;
    }
    public int getHighCardValueForStraight(){
        int tempMax = Collections.max(this.getNumericValues());
//        if(this.getNumericValues().contains(1)) return 11;
        if (tempMax == 13) return 13;
        else if (tempMax == 12) return 12;
        else if (tempMax == 11) return 11;
        else return tempMax;
    }

    public int getTwoPairSingleCardValue(){
        ArrayList<Integer> arr = this.getNumericValues();
        int single = 0;
        for(int x : arr){
            if(Collections.frequency(arr,x) == 1){
                single = x;
            }
        }
        if(single == 1) return 14;
        else return single;
    }

    public int getOnePairSingleValues(){
        ArrayList<Integer> handArray = this.getNumericValues();
        ArrayList<Integer> singlesArray = new ArrayList<Integer>();
        for(int x : handArray){
            if(Collections.frequency(handArray,x) == 1){
                singlesArray.add(x);
            }
        }
        Collections.sort(singlesArray);
        int score = (singlesArray.get(0) * 10) +
                (singlesArray.get(1) * 100) +
                (singlesArray.get(2) * 1000);
        return score;
    }

    public int evaluateHand(){
        if (this.isStraightFlush()) return 8000000 + this.getHighCardValue();
        else if(this.isFourKind())  return 7000000 + this.getNumericValuesForScoring().get(2);
        else if(this.isFullHouse()) return 6000000 + this.getNumericValuesForScoring().get(2);
        else if(this.isFlush())     return 5000000 + this.getHighCardValue();
        // straights, does A.2.3.4.5 beat 9.10.J.Q.K? assuming no
        else if(this.isStraight())  return 4000000 + this.getHighCardValueForStraight();
        else if(this.isThreeKind()) return 3000000 + this.getNumericValuesForScoring().get(2);
        else if(this.isTwoPair())   return 2000000 +
                (this.getNumericValuesForScoring().get(3) * 1000) +
                (this.getNumericValuesForScoring().get(1) * 100) +
                this.getTwoPairSingleCardValue();
        else if(this.isPair())      return 1000000 + this.getOnePairSingleValues();
        else                        return this.getHighCardValue();
    }


    @Override
    public String toString() {
        return "Hand: \n" + aHand;
    }
}
