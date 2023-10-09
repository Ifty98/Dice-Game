 import java.util.Arrays;
import java.util.Scanner;

public class Dice_game {
    //method to throw dices
    public static int[] playDices(int dices) {
        int[] randomNum = new int[dices];
        System.out.print("Throw: ");
        //generate a random number between 1 and 6, and store it inside an array 
        for (int j=0; j<dices; j++) {
            randomNum[j] = (int) (Math.random() * 6 - 1 + 1) + 1; 
            System.out.print("[" + randomNum[j] + "]" + " ");
        }
        System.out.println(" ");
        System.out.print("Sorted: ");
        //sort the array of random numbers from highest to lowest
        Arrays.sort(randomNum);
        for (int j=0; j<dices; j++) {
            System.out.print("[" + randomNum[j] + "]" + " ");
        }
        System.out.println(" ");
        return randomNum;
    }
    public static void main(String[] args) {
        int players = 3;
        int rounds = 3;
        int round = 1;
        //declare variables to store players scores in each round and add it to the final score
        int score11 = 0;
        int score12 = 0;
        int score13 = 0;
        int score21 = 0; 
        int score22 = 0;
        int score23 = 0;
        int score31 = 0;
        int score32 = 0;
        int score33 = 0;
        int total1 = 0;
        int total2 = 0;
        int total3 = 0;
        Scanner sc = new Scanner(System.in);

        for (int z=0; z<rounds; z++) {
        int player = 1;
        System.out.println("Round " + (z+1));

        //changes to the next player once the actual player finish his turn 
        for (int i=0; i<players; i++) {
        //declares the intial amount of dices
        int dices = 8;
        System.out.println("Player" + (i+1));
        System.out.println("First throw of this turn, starting with " + dices + " dice.");
        //asks to the player to input 't' to throw the dices
        System.out.print("Enter 't' to throw > ");
        char throwDices = sc.next().charAt(0);
        /*if the input introduced is not equal to 't', the program displays an error message
        and ask again to indroduce 't'*/
        while (throwDices != 't') {
            System.out.println("Incorrect input");
            System.out.print("Enter 't' to throw > ");
            throwDices = sc.next().charAt(0);
        }
        //calls the method to throw the dices and store the sorted array of random numbers
        int randomNum[] = playDices(dices);
        //asks to the player to introduce the value of the dice which he wants to take 
        System.out.print("Select die value to set aside > ");
        int select_dice = sc.nextInt();
        int throw_number = 0;
        int[] choosen_dice = new int[6];
        boolean selected_number = false;
        boolean choosen_number = false;
        /*checks if the selected number to set aside is equal to the value of any of the
        generated dices*/ 
        for (int k=0; k<randomNum.length; k++) {
            if (randomNum[k] == select_dice){
                selected_number = true;
                break;
            }
            else {
                selected_number = false;
            }
        }
        /*if the selected value to set aside is not equal to a generated dice value then the
        program display an error message and ask again to introduce a value to set aside*/  
        while (!selected_number) {
            System.out.println("Selected die value not found!!");
            System.out.print("Select die value to set aside > ");
            select_dice = sc.nextInt();
            for (int k=0; k<randomNum.length; k++) {
                if (randomNum[k] == select_dice){
                    selected_number = true;
                    break;
                }
                else {
                    selected_number = false;
                }
            }
        }
        //stores the value of the dices that already has been taken aside 
        choosen_dice[throw_number] = select_dice;
        throw_number++;
        int dice_amount = 0;
        /*checks the array of dices to find the number of values that are the same
        as the selected value to set aside*/
        for (int k=0; k<randomNum.length; k++) {
            if (randomNum[k] == select_dice) {
                dice_amount++;
            }
        }
        System.out.println("There are " + dice_amount + " dice that have that value");
        //displays the amount of the dices that player can choose to set aside
        System.out.print("You can choose to keep ");
        if (dice_amount == 1) {
            System.out.println(dice_amount + " dice of value " + select_dice);
        }
        else {
            for (int k=1; k<=dice_amount; k++) {
                if (k == dice_amount) {
                    System.out.print(" or " + dice_amount);
                    break;
                }
                else {
                    System.out.print(k + ", ");
                }
            }
            System.out.println(" dice of value " + select_dice);
        }
        //asks to the player to input the amount of dices to set aside
        System.out.print("How many do you want to set aside > ");
        int set_aside = sc.nextInt();
        /*if the input of the amount of dices to set aside is greater that the amount which the
        player can choose or if it is less than one then the program displays an error message
        and ask again for the number of dices to set aside*/
        while (set_aside > dice_amount || set_aside < 1) {
            System.out.println("There are not this amount of the selected dice!!");
            System.out.print("How many do you want to set aside > ");
            set_aside = sc.nextInt();
        }
        /*multiply the value of the dice and its amount to set aside to get the score and store it
        inside a variable*/
        int score = set_aside * select_dice;
        System.out.println("Score so far = " + score);
        System.out.println("You have kept " + set_aside + " dice so far.");
        //decrease the number of dices knowing how many have been taken so far
        dices = dices - set_aside;
        //asks to the player to finish or continue throwing the dices in this turn if he has enough dices
        if (dices > 0) {
        System.out.print("Finish turn or continue (enter 'f' to finish turn or 'c' to continue and throw again) > ");
        char finish = sc.next().charAt(0);
        /*if the player introduce an input that is not to finish or continue his turn then the program display
        an error message and ask again to the player to continue or finish*/
        while (finish != 'f' && finish != 'c') {
            System.out.println("Incorrect input!!");
            System.out.print("Finish turn or continue (enter 'f' to finish turn or 'c' to continue and throw again) > ");
            finish = sc.next().charAt(0);
        }
        //if the player want to continue then he can throw again the rest of the dices 
        while (finish == 'c') {
            System.out.println("Taking " + dices + " dice forward to next throw.");
            System.out.println("Next throw of this turn.");
            System.out.print("Enter 't' to throw > ");
            throwDices = sc.next().charAt(0);
            while (throwDices != 't') {
                System.out.println("Incorrect input");
                System.out.print("Enter 't' to throw > ");
                throwDices = sc.next().charAt(0);
            }
            randomNum = playDices(dices);
            System.out.print("Select die value to set aside > ");
            select_dice = sc.nextInt();
            selected_number = false;
            choosen_number = false;
            //checks if the value of the dice that player want to set aside was taken before
            for (int j=0; j<choosen_dice.length; j++) {
                if (select_dice == 0) {
                    choosen_number = false;
                    break;
                }
                if (choosen_dice[j] == select_dice) {
                   choosen_number = true;
                   break;
                }
                else {
                    choosen_number = false;
                }
            }
            /*if this value was taken before then the program display an error message
            and ask again to introduce a value to set aside*/
            while (choosen_number) {
                System.out.println("This selected dice value has been taken before");
                System.out.print("Select die value to set aside > ");
                select_dice = sc.nextInt();
                for (int j=0; j<choosen_dice.length; j++) {
                    if (choosen_dice[j] == select_dice) {
                       choosen_number = true;
                       break;
                    }
                    else {
                        choosen_number = false;
                    }
                }
            }
            /*if the value to set aside was not taken before then the program checks if this value exist
            in the randomNum array*/ 
            for (int k=0; k<randomNum.length; k++) {
                if (randomNum[k] == select_dice){
                    selected_number = true;
                    break;
                }
                else {
                    selected_number = false;
                }
            }
            //if it does not exist then it keep asking to introduce a value to set aside
            while (!selected_number) {
                System.out.println("Selected die value not found!!");
                System.out.print("Select die value to set aside > ");
                select_dice = sc.nextInt();
                for (int k=0; k<randomNum.length; k++) {
                    if (randomNum[k] == select_dice){
                        selected_number = true;
                        break;
                    }
                    else {
                        selected_number = false;
                    }
                }
            }
            /*once the program accepts the value to set aside it store this value again inside the array
            which contains the already selected values to set aside*/
            choosen_dice[throw_number] = select_dice;
            throw_number++;
            dice_amount = 0;
            for (int k=0; k<randomNum.length; k++) {
                if (randomNum[k] == select_dice) {
                    dice_amount++;
                }
            }
            System.out.println("There are " + dice_amount + " dice that have that value");
            System.out.print("You can choose to keep ");
            if (dice_amount == 1) {
               System.out.println(dice_amount + " dice of value " + select_dice);
            }
            else {
               for (int k=1; k<=dice_amount; k++) {
                if (k == dice_amount) {
                    System.out.print(" or " + dice_amount);
                    break;
                }
                else {
                    System.out.print(k + ", ");
                }
               }
               System.out.println(" dice of value " + select_dice);
            }
            System.out.print("How many do you want to set aside > ");
            set_aside = sc.nextInt();
            while (set_aside > dice_amount || set_aside < 1) {
              System.out.println("There are not this amount of the selected dice!!");
              System.out.print("How many do you want to set aside > ");
              set_aside = sc.nextInt();
            }
            score = score +(set_aside * select_dice);
            System.out.println("Score so far = " + score);
            System.out.println("You have kept " + set_aside + " dice so far.");
            dices = dices - set_aside;
            //if there are enough dices the program keep asking to the player if he wants to continue or finish
            if (dices > 0) {
            System.out.print("Finish turn or continue (enter 'f' to finish turn or 'c' to continue and throw again) > ");
            finish = sc.next().charAt(0);
            while (finish != 'f' && finish != 'c') {
              System.out.println("Incorrect input!!");
              System.out.print("Finish turn or continue (enter 'f' to finish turn or 'c' to continue and throw again) > ");
              finish = sc.next().charAt(0);
            }
            }
            //if there are not enough dices the program gives the turn to the next player
            else {
                break;
            }
        }
        }
        /*checks in which round the players are and which player is playing to store the score of all players
        in each round*/
        if (round == 1) {
          if (player == 1) {
            score11 = score;
            System.out.println("Final score for that turn for Player " + player + " = " + score11);
          }
          if (player == 2) {
            score12 = score;
            System.out.println("Final score for that turn for Player " + player + " = " + score12);
          }
          if (player == 3) {
            score13 = score;
            System.out.println("Final score for that turn for Player " + player + " = " + score13);
            //after last player finish to play the program updates the total score of all players
            total1 = score11 + score21 + score31;
            total2 = score12 + score22 + score32;
            total3 = score13 + score23 + score33;
            //generates a table to display players scores in each round and their total score so far
            System.out.printf("--------------------------------------------------%n");
            System.out.printf("|  %4s  |  %4s  |  %4s  |  %4s  |%n", "Round", "Player 1", "Player 2", "Player 3");
            System.out.printf("--------------------------------------------------%n");
            System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "1", score11, score12, score13);
            System.out.printf("--------------------------------------------------%n");
            System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "2", "---", "---", "---");
            System.out.printf("--------------------------------------------------%n");
            System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "3", "---", "---", "---");
            System.out.printf("--------------------------------------------------%n");
            System.out.printf("|  %-7s|     %-5s  |     %-5s  |     %-5s  |%n", "Total", total1, total2, total3);
            System.out.printf("--------------------------------------------------%n");
          }
        }
        if (round == 2) {
            if (player == 1) {
              score21 = score;
              System.out.println("Final score for that turn for Player " + player + " = " + score21);
            }
            if (player == 2) {
              score22 = score;
              System.out.println("Final score for that turn for Player " + player + " = " + score22);
            }
            if (player == 3) {
              score23 = score;
              System.out.println("Final score for that turn for Player " + player + " = " + score23);
              total1 = score11 + score21 + score31;
              total2 = score12 + score22 + score32;
              total3 = score13 + score23 + score33;
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|  %4s  |  %4s  |  %4s  |  %4s  |%n", "Round", "Player 1", "Player 2", "Player 3");
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "1", score11, score12, score13);
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "2", score21, score22, score23);
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "3", "---", "---", "---");
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|  %-7s|     %-5s  |     %-5s  |     %-5s  |%n", "Total", total1, total2, total3);
              System.out.printf("--------------------------------------------------%n");
            }
        }
        if (round == 3) {
            if (player == 1) {
              score31 = score;
              System.out.println("Final score for that turn for Player " + player + " = " + score31);
            }
            if (player == 2) {
              score32 = score;
              System.out.println("Final score for that turn for Player " + player + " = " + score32);
            }
            if (player == 3) {
              score33 = score;
              System.out.println("Final score for that turn for Player " + player + " = " + score33);
              total1 = score11 + score21 + score31;
              total2 = score12 + score22 + score32;
              total3 = score13 + score23 + score33;
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|  %4s  |  %4s  |  %4s  |  %4s  |%n", "Round", "Player 1", "Player 2", "Player 3");
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "1", score11, score12, score13);
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "2", score21, score22, score23);
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|    %-5s|     %-5s  |     %-5s  |     %-5s  |%n", "3", score31, score32, score33);
              System.out.printf("--------------------------------------------------%n");
              System.out.printf("|  %-7s|     %-5s  |     %-5s  |     %-5s  |%n", "Total", total1, total2, total3);
              System.out.printf("--------------------------------------------------%n");
            }
          }
        //when a player finish his turn, the player number increase by 1 to let the next player start the game
        player++;
        }
        //when all players finish one round, the round number increase by 1 to go to the next round 
        round++;
    }
    //at the end of the game, the program compares all the total scores of players and displays the winner
    if (total1 > total2 && total1 > total3) {
        System.out.println("Player 1 wins that game.");
    }
    if (total2 > total1 && total2 > total3) {
        System.out.println("Player 2 wins that game.");
    }
    if (total3 > total1 && total3 > total2) {
        System.out.println("Player 3 wins that game.");
    }
    else {
        System.out.println("No winner. There is a draw between the players");
    }
    sc.close();
    }
}
