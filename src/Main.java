import java.util.*;

public class Main {

    public static void main(String[] args) {

//        Scanner reader = new Scanner(System.in);
//
//        while(true){
//
//            System.out.print("Black: ");
//            String black = reader.nextLine();
//            if(black.isEmpty()) break;
//
//            System.out.print("White: ");
//            String white = reader.nextLine();
//            if(white.isEmpty()) break;
//
//            Hand w = new Hand(white);
//            Hand b = new Hand(black);
//
//            System.out.println(compareHands(w,b));
//        }
//
//        System.out.println("Thanks for playing!");

//        Hand a = new Hand("2h 5d 7S AC 6D");
        Hand a = new Hand("AH AH AH AH AH");
        Hand b = new Hand("AO AC AB AA 10W");

        Hand c = new Hand("9h 9d 9s qS qd");
        Hand d = new Hand("4D 5D 5C 5S 4C");

        Hand e = new Hand("2H 3D 9S 4C 6D");
        Hand f = new Hand("2h 3H 4S 8C KH");

        Hand g = new Hand("2H 3D 5S 9C KD");
        Hand h = new Hand("2D 3H 5C 9S KH");

        System.out.println(compareHands(a,b));
        System.out.println(compareHands(c,d));
        System.out.println(compareHands(e,f));
        System.out.println(compareHands(g,h));
    }

    public static String compareHands(Hand white, Hand black){
        int whiteScore = white.evaluateHand();
        int blackScore = black.evaluateHand();

        if (whiteScore > blackScore) return "White wins. - with " + typeOfHand(white, black);
        else if (blackScore > whiteScore) return "Black wins. - with " + typeOfHand(black, white);
        else if (blackScore == whiteScore) return "Tie.";
        else return "Error comparing hands.";
    }

    public static String typeOfHand(Hand hand1, Hand hand2){
        if(hand1.isStraightFlush())  return "straight flush";
        else if(hand1.isFourKind())  return "four of a kind";
        else if(hand1.isFullHouse()){
            int h1 = hand1.getNumericValuesForScoring().get(2);
            int h2 = hand2.getNumericValuesForScoring().get(2);
            return "full house: " + h1 + " over " + h2;
        }
        else if(hand1.isFlush())     return "flush";
        else if(hand1.isStraight())  return "straight";
        else if(hand1.isThreeKind()) return "three of a kind";
        else if(hand1.isTwoPair())   return "two pair";
        else if(hand1.isPair())      return "one pair";
        else return "high card: " + hand1.getHighCard();
    }
}
