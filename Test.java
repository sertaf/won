package lab_2_2.webWork.Poker.src.main.java.Poker;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        /**
         * 输入: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH 输出: White wins
         * 输入: Black: 2H 4S 4C 2D 4H White: 2S 8S AS QS 3S 输出: White wins
         * 输入: Black: 2H 3H 5H 9H KH White: 2C 3H 4S 5C 6H 输出: Black wins
         * 输入: Black: 2H 3D 5S 9C KD White: 2D 3H 5C 9S KH 输出: Tie
         */

        Scanner input=new Scanner(System.in);
        String str;
        str=input.nextLine();
        int start = str.indexOf(":");
        String name1 = str.substring(0,start);
        String str1=str.substring(start+2);
        Poker poker1=new Poker(str1.charAt(0),str1.charAt(1));
        Poker poker2=new Poker(str1.charAt(3),str1.charAt(4));
        Poker poker3=new Poker(str1.charAt(6),str1.charAt(7));
        Poker poker4=new Poker(str1.charAt(9),str1.charAt(10));
        Poker poker5=new Poker(str1.charAt(12),str1.charAt(13));
        Pokers pokers1=new Pokers(poker1,poker2,poker3,poker4,poker5);

        start = str1.indexOf(":");
        String name2 = str1.substring(15,start);
        String str2=str1.substring(start+2);
        Poker poker6=new Poker(str2.charAt(0),str2.charAt(1));
        Poker poker7=new Poker(str2.charAt(3),str2.charAt(4));
        Poker poker8=new Poker(str2.charAt(6),str2.charAt(7));
        Poker poker9=new Poker(str2.charAt(9),str2.charAt(10));
        Poker poker0=new Poker(str2.charAt(12),str2.charAt(13));
        Pokers pokers2=new Pokers(poker6,poker7,poker8,poker9,poker0);

        int isWin=pokers1.biggerThan(pokers2);
        if(isWin==1)
            System.out.println(name1+" wins");
        else if(isWin==-1)
            System.out.println(name2+" wins");
        else System.out.println("Tie");
    }
}
