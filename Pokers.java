package lab_2_2.webWork.Poker.src.main.java.Poker;

import java.util.Vector;

enum pokersPriority {
    Royal_Flush, Straight_Flush, Four_of_a_Kind, Full_House,
    Flush, Straight, Three_of_a_Kind, Two_Pairs, One_Pair, High_Poker;
}

public class Pokers {
    private Vector<Poker> pokers=new Vector<>();
    private pokersPriority type;
    private int level;

    public Pokers(Poker one, Poker two, Poker three, Poker four, Poker five) {
        pokers.add(one);
        pokers.add(two);
        pokers.add(three);
        pokers.add(four);
        pokers.add(five);
        for(int i=0;i<4;i++){
            for(int j=0;j<4-i;j++)
            if(pokers.get(j).getIDValue()>pokers.get(j+1).getIDValue()){
                Poker temp=pokers.get(j);
                pokers.set(j,pokers.get(j+1));
                pokers.set(j+1,temp);
            }
        }
    }

    public pokersPriority getPokersType() {
        int sameCount1 = 0;//牌面相同的值
        type = pokersPriority.High_Poker;//默认为散牌,High_Poker
        level=0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++)
                if (pokers.get(i).getIDValue() == pokers.get(j).getIDValue())
                    sameCount1++;
        }
        switch (sameCount1) {
            case 1://One_Pair
                type = pokersPriority.One_Pair;
                level=1;
                break;
            case 2://Two_Pairs
                type = pokersPriority.Two_Pairs;
                level=2;
                break;
            case 3://Three_of_a_kind
                type = pokersPriority.Three_of_a_Kind;
                level=3;
                break;
            case 4://Full_House
                type = pokersPriority.Full_House;
                level=6;
                break;
            case 6://Four_of_a_Kind
                type = pokersPriority.Four_of_a_Kind;
                level=7;
                break;
        }
        if (pokers.get(0).getIDValue() + 4 == pokers.get(4).getIDValue()) {//Straight
            type = pokersPriority.Straight;
            level=4;
        }

        int sameCount2 = 0;//花色相同的值
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++)
                if (pokers.get(i).getTypeValue() == pokers.get(j).getTypeValue())
                    sameCount2++;
        }
        switch (sameCount2) {
            case 10://Flush
                type = pokersPriority.Flush;
                level=5;
                if (pokers.get(0).getIDValue() + 4 == pokers.get(4).getIDValue()) {//Straight_Flush
                    type = pokersPriority.Straight_Flush;
                    level=8;
                    if (pokers.get(4).getIDValue() == 14) {//Royal_Flush
                        type = pokersPriority.Royal_Flush;
                        level = 9;
                    }
                }
        }
        return type;
    }

    public Vector<Poker> getPokers(){
        return pokers;
    }

    public int getLevel(){
        return level;
    }

    public int biggerThan(Pokers otherPokers){
        int otherLevel=otherPokers.level;
        if(level>otherLevel)
            return 1;
        else if (level<otherLevel)
            return -1;
        else {
            if (pokers.get(4).getIDValue() > otherPokers.getPokers().get(4).getIDValue())
                return 1;
            else if(pokers.get(4).getIDValue() < otherPokers.getPokers().get(4).getIDValue())
                return -1;
            else return 0;
        }
    }
}
