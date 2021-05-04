package com.codilla.rps.CheatingChancesVersion;

import java.util.*;

public class RpsGameCore {

    private boolean end = false;
    private int roundsNumber = 0;

    private RpsConditions rpsConditions = new RpsConditions();

    private int playerTotalScore;
    private int computerTotalScore;
    private int roundCounter;


    void startNewGame() {

        while (true) {
            end = false;
            playerTotalScore = 0;
            computerTotalScore = 0;
            roundCounter = 0;
            roundsNumber = 0;

            completeGameData();
            checkInputData();
            core();
            System.gc();

            nextGameChecker();

        }
    }

    private void completeGameData() {
        System.out.println("Hi Gammer!\r\n" +
                "You are playing the \'rock-paper-scissors\' game.\r\n" +
                "Rules are simple:\r\n" +
                "rock     (1) vs. paper    (2) : paper wins \r\n" +
                "paper    (2) vs. scissors (3) : scissors wins \r\n" +
                "scissors (3) vs. rock     (1) : rock wins\n");
        System.out.println("It's quite simple - isn't it ? :-)");
        System.out.println("\nCommands are simple as well: ");
        System.out.println("press 1 to choose rock \r\n" +
                "press 2 to choose paper \r\n" +
                "press 3 to choose scissors \r\n");
        System.out.println("\nOK. So - let's start! \nInput a number rounds needed to win and confirm pressing ENTER:");
    }

    private void checkInputData() {

        int wrongInputNumber = 0;

        Class integerClass = Integer.class;
        Class expectedClass = Object.class;

        while (true) {
            Scanner inputScanner = new Scanner(System.in);
            int inputRoundsNumber = 0;

            try {
                inputRoundsNumber = inputScanner.nextInt();
                expectedClass = Integer.valueOf(inputRoundsNumber).getClass();

            } catch (Exception exception) {
                wrongInputNumber++;
                if (wrongInputNumber == 3) {
                    System.out.println(" OK. THE GAME IS OVER! Bye.");
                    System.exit(0);
                }
                System.out.println("Plizzz... choose the NUMBER! OK ...? ");
            }
            if (expectedClass.equals(integerClass)) {
                roundsNumber = inputRoundsNumber;
                System.out.println("\nOK. The number of rounds needed to win the game is : " + roundsNumber);
                break;
            }
        }
    }


    private void core() {

        while (!end) {
            roundCounter++;
            System.out.println("\nRound number: " + roundCounter);
            System.out.println("Take your choice and press the number (1-3) and confirm pressing Enter: \n");

            roundsResultGenerator();

            if ((roundsNumber == playerTotalScore) || (roundsNumber == computerTotalScore)) end = true;
        }
        finishGame();
    }

    private void roundsResultGenerator() {

        List<Integer> intToChoose = Arrays.asList(1, 2, 3);
        int playerResult = 0;

        do {
            Scanner scanner2 = new Scanner(System.in);

            try {
                playerResult = scanner2.nextInt();
                if (!intToChoose.contains(playerResult)) throw new Exception();

            } catch (Exception e) {

                System.out.println("Choose from: 1 or 2 or 3");
                scanner2.reset();
            }

        } while (!intToChoose.contains(playerResult));

        int computerResult = getComputerResult(playerResult);

        RpsRoundResult roundResult = new RpsRoundResult(playerResult, computerResult);
        System.out.println();

        String winnerString = rpsConditions.scoreActionSelector(roundResult);

        if (winnerString.endsWith("Win!")) {
            playerTotalScore++;
        }
        if (winnerString.endsWith("Wins!")) {
            computerTotalScore++;
        }

        System.out.println("After this round total results are: \nYou = " + playerTotalScore + "   Computer = " + computerTotalScore);
    }

    private int getComputerResult(int playerResult) {

        List<Integer> stack = new ArrayList<>();

        switch (playerResult) {
            case 1:
                stack = Arrays.asList(1, 3, 2, 2);
                break;
            case 2:
                stack = Arrays.asList(2, 1, 3, 3);
                break;
            case 3:
                stack = Arrays.asList(3, 2, 1, 1);
                break;
        }
        LinkedList<Integer> selectedStack = new LinkedList<>(stack);

        Collections.shuffle(selectedStack);

        return selectedStack.getFirst();
    }

    private void finishGame() {

        String text = computerTotalScore > playerTotalScore ? "Computer wins the Game!" : "You Win the Game!";
        System.out.println(text);
        System.out.println("\n ---- Statistics: ----");
        System.out.println("Rounds played:  " + roundCounter);
        System.out.println("Rounds played taking points:  " + (playerTotalScore + computerTotalScore) + "\n");
    }

    private void nextGameChecker() {
        System.out.println(" To play again press key: \"N\". For EXIT press key:  \"X\" ");
        String NX = new Scanner(System.in).nextLine().toLowerCase();
        while (!(NX.equals("x") || NX.equals("n"))) {
            nextGameChecker();
        }
        if (NX.equals("x")) {
            System.out.println("Program has finished!");
            System.exit(0);
        }
    }
}
