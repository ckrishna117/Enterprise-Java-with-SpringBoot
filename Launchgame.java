


import java.util.Scanner;
/***
 * There are total 8 players in the league.Each player will play againist another player winner will move to further rounds.
 * Initially 8 players participate in Quarters/round of 8 ,winners from the 4 quarter final matches will play semi-finals/round of 4
 * winners from both semi-finals will advance into finals.
 * Guesser should guess any number only from 1 to 10 range.
 * Player Should guess any number only from 1 to 10 range.
 * if player matches the guessed number with guesser and if there is no tie he will be the winner of that particular match and will advance into further rounds
 * 
 **/
class Guesser {
    int guessNum;

    public int guessNumber() {
        boolean validGuess = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Guesser kindly guess the number");
        while (validGuess) {
            guessNum = scan.nextInt();
            if (guessNum > 0 && guessNum < 11) {
                validGuess = false;
            } else {
                System.out.println("guesser kindly guess the number from 1 to 10");
            }
        }


        return guessNum;

    }

}

class Player {
    int pguessNum;
    int playerId;

    public Player(int playerId) {
        this.playerId = playerId;
    }


    public int guessNumber() {
        boolean validGuess = true;

        Scanner scan = new Scanner(System.in);
        System.out.println("Player" + playerId + " kindly guess the number");
        while (validGuess) {
            pguessNum = scan.nextInt();
            if (pguessNum >= 0 && pguessNum < 11) {
                validGuess = false;
            } else {
                System.out.println("Player" + playerId + "kindly guess the number from 1 to 10");
            }
        }

        return pguessNum;
    }
}

class Umpire {


    public int collectNumFromGuesser(Guesser g) {

        int numFromGuesser = g.guessNumber();
        return numFromGuesser;
    }


    public int collectNumFromPlayer(Player p) {

        int numFromPlayer = p.guessNumber();

        return numFromPlayer;
    }


    Player compareGuessFromBothPlayers(Player p1, Player p2, Guesser g) {

        int guessinput, player1input, player2input;
        boolean result = true;// until only one player wins players should continue guessing
        Player won = null;

        while (result) {
            guessinput = collectNumFromGuesser(g);
            player1input = collectNumFromPlayer(p1);
            player2input = collectNumFromPlayer(p2);
            if (guessinput == player1input && guessinput != player2input) {
                System.out.println("Player " + p1.playerId + " Congratulations You had won the Game");
                result = false;
                won = p1;

            } else if (guessinput == player2input && guessinput != player1input) {
                System.out.println("Player " + p2.playerId + " Congratulations You had won the Game");
                result = false;
                won = p2;
            } else if (guessinput != player2input && guessinput != player1input) {
                System.out.println("Game lost...please try guessing again");

            } else {
                System.out.println("Its a tie...please try guessing again");
            }

        }

        return won;
    }

    Player scheduleMatch(Player p1, Player p2, Guesser g) {

        Player won;
        won = compareGuessFromBothPlayers(p1, p2, g);


        return won;
    }

    public void tournamentEnroll() {
        Guesser g = new Guesser();
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Player p3 = new Player(3);
        Player p4 = new Player(4);
        Player p5 = new Player(5);
        Player p6 = new Player(6);
        Player p7 = new Player(7);
        Player p8 = new Player(8);

        System.out.println("Quarters leg/round of 8started.....");
        System.out.println("match between player "+p1.playerId+" and player "+p2.playerId+" started.....");
        Player firstQualfiedForsemies = scheduleMatch(p1, p2, g);
        System.out.println("-----------------------------------------");
        System.out.println("match between player "+p3.playerId+" and player "+p4.playerId+" started.....");
        Player secondQualfiedForSemies = scheduleMatch(p3, p4, g);
        System.out.println("-----------------------------------------");
        System.out.println("match between player "+p5.playerId+" and player "+p6.playerId+" started.....");
        Player thirdQualfiedForSemies = scheduleMatch(p5, p6, g);
        System.out.println("-----------------------------------------");
        System.out.println("match between player "+p7.playerId+" and player "+p8.playerId+" started.....");
        Player fourthQualifiedForSemies = scheduleMatch(p7, p8, g);
        System.out.println("-----------------------------------------");
        System.out.println("Semi final /round of 4 had started.....");
        System.out.println("match between player "+firstQualfiedForsemies.playerId+" and player "+thirdQualfiedForSemies.playerId+" started.....");
        Player firstQualifiedForFinals = scheduleMatch(firstQualfiedForsemies, thirdQualfiedForSemies, g);
        System.out.println("-----------------------------------------");
        System.out.println("match between player "+secondQualfiedForSemies.playerId+" and player "+fourthQualifiedForSemies.playerId+" started.....");

        Player secondQualfiedForFinals = scheduleMatch(secondQualfiedForSemies, fourthQualifiedForSemies, g);
        System.out.println("-----------------------------------------");
        System.out.println("Finals had started.....");
        System.out.println("match between player "+firstQualifiedForFinals.playerId+" and player "+secondQualfiedForFinals.playerId+" started.....");

        Player finalWinner = scheduleMatch(firstQualifiedForFinals, secondQualfiedForFinals, g);
        System.out.println("Hurray to!!! player "+finalWinner.playerId+" Won the final!!!.....................");
        System.out.println("Thats it from the presentation area,what a tournament so far!!!...will meet again next time......");
    }

}


public class Launchgame {

    public static void main(String[] args) {
        
        Umpire u = new Umpire();
        u.tournamentEnroll();


    }

}







