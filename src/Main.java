import java.util.*;

public class Main {

    public static void main(String[] args) {

        Hand a = new Hand("4H 3H 7H 6H 5H");
        Hand b = new Hand("4H 6H 6H 6H 6H");
        Hand c = new Hand("4H 3H 3H 4H 3H");
        Hand d = new Hand("4H 3H 3H 2H 3H");
        Hand e = new Hand("AH 3H 4H 2D 5H");
        Hand f = new Hand("4H KH KS KD 5H");
        Hand g = new Hand("4H 3H 3H 4S 5H");
        Hand h = new Hand("9S 3H 3H 4S 5H");
        Hand i = new Hand("9S 10C 2D 4S 5H");

        System.out.println(evaluateHand(a));
        System.out.println(evaluateHand(b));
        System.out.println(evaluateHand(c));
        System.out.println(evaluateHand(d));
        System.out.println(evaluateHand(e));
        System.out.println(evaluateHand(f));
        System.out.println(evaluateHand(g));
        System.out.println(evaluateHand(h));
        System.out.println(evaluateHand(i));
    }

    public static String evaluateHand(Hand hand){
        if(hand.isStraightFlush()) return "Straight flush";
        else if(hand.isFourKind()) return "Four kind";
        else if(hand.isFullHouse()) return "Full house";
        else if(hand.isFlush()) return "Flush";
        else if(hand.isStraight()) return "Straight";
        else if(hand.isThreeKind()) return "Three of a kind";
        else if(hand.isTwoPair()) return "Two pair";
        else if(hand.isPair()) return "One pair";
        else return "High card: " + hand.getHighCard();
    }

    public static String evaluateWinner(Hand h1, Hand h2){
        int score1 = 0;
        int score2 = 0;




    }



}
