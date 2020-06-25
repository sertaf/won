package lab_2_2.webWork.Poker.src.main.java.Poker;

public class Poker {
    private char pokerID;
    private char pokerType;

    public Poker(){}

    public Poker(char id, char type) {
        pokerID = id;
        pokerType = type;
    }

    public String toString(){
        return String.valueOf(pokerID)+String.valueOf(pokerType);
    }

    public int getIDValue() {
        int val;
        switch (pokerID){
            case '2':
                val=2;
                break;
            case '3':
                val=3;
                break;
            case '4':
                val=4;
                break;
            case '5':
                val=5;
                break;
            case '6':
                val=6;
                break;
            case '7':
                val=7;
                break;
            case '8':
                val=8;
                break;
            case '9':
                val=9;
                break;
            case 'T':
                val=10;
                break;
            case 'J':
                val=11;
                break;
            case 'Q':
                val=12;
                break;
            case 'K':
                val=13;
                break;
            case 'A':
                val=14;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pokerID);
        }
        return val;
    }

    public int getTypeValue() {
        int val;
        switch (pokerType){
            case 'D'://方片
                val='D';
                break;
            case 'S'://黑桃
                val='S';
                break;
            case 'H'://红桃
                val='H';
                break;
            case 'C'://梅花
                val='C';
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pokerType);
        }
        return val;
    }
}
