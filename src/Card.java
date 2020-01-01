public class Card {

    private String value;
    private String suite;

    public Card(String card){
        if(card.length() == 3){
            value = card.substring(0,2);
            suite = card.substring(2).toUpperCase();
        } else{
            value = card.substring(0,1);
            suite = card.substring(1).toUpperCase();
        }
    }

    public String getSuite(){
        return (this.suite);
    }

    public String getValue(){
        return (this.value);
    }

    public int getNumericValue(){
        if (this.value.equals("A")) return 1;
        else if (this.value.equals("J")) return 11;
        else if (this.value.equals("Q")) return 12;
        else if (this.value.equals("K")) return 13;
        else return Integer.parseInt(this.value);
    }


    @Override
    public String toString() {
        return "Card: " + value + suite;
    }
}
