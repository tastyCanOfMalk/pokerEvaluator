import java.util.*;

public class Main {

    public static void main(String[] args) {

        // test straight flush
        Hand sf = new Hand("4H 3H 7H 6H 5H");
//        System.out.println(sf.isStraightFlush());
//        System.out.println(sf.isFlush());
//        System.out.println(sf.isStraight());

//        Hand tp = new Hand("4H 4D 6D 6H 5H");
//        Hand p = new Hand("4H 4D 2D 6H 5H");


        Hand fkh = new Hand("QH QD QS QC KD");
        System.out.println(fkh);
        System.out.println(fkh.isFourKind());
        System.out.println(fkh.isFullHouse());
        System.out.println(fkh.isThreeKind());
        System.out.println();

        Hand fh = new Hand("QH QD QS KC KD");
        System.out.println(fh);
        System.out.println(fh.isFourKind());
        System.out.println(fh.isFullHouse());
        System.out.println(fh.isThreeKind());
        System.out.println();

        Hand tk = new Hand("QH QD QS KC 2D");
        System.out.println(tk);
        System.out.println(tk.isFourKind());
        System.out.println(tk.isFullHouse());
        System.out.println(tk.isThreeKind());
        System.out.println();


        HashSet handSet = new HashSet(fkh.getNumericValues());
        // convert to list for indexing
        ArrayList<Integer> arraySet = new ArrayList<Integer>(handSet);
        // count occurrences of get(0) and get(1) in original array


        int a = 0;
        int b = 0;
        for(int x : fkh.getNumericValues()){
            if(x == arraySet.get(0)) a++;
            else if(x == arraySet.get(1)) b++;
        }
        System.out.println(Math.max(a,b));
        System.out.println(fkh.getMaxUniqueCount());





        Hand fkl = new Hand("QH QD QS QC 2D");
//        Hand fh = new Hand("2H AH 5H 10H KH");
        Hand tf = new Hand("2H AH 3H 4H 5H");
        Hand s = new Hand("2H AH 3H 4H 5H");



    }

}
