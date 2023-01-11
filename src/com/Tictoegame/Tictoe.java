package com.Tictoegame;

import java.util.*;

public class Tictoe {


    static char[] board = new char[9];
    static char[] choice = new char[]{'X', 'O'};
    static char userChoice;
    static char cpuChoice;
    static String winner = null;
    static String play = null;

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Tictoe t1 = new Tictoe();

        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }
        t1.choiceMethod();
        t1.printBoard();

        t1.tossMethod();
        while (winner == null) {
            if (play == "user") {
                System.out.println("");
                System.out.println("Its your turn, Enter a slot number to place: ");
                t1.showBoard();
            } else {
                System.out.println("");
                System.out.println(" Its computer turn  ");
                t1.cpuBoard();
            }
        }
        if (winner == "draw") {
            System.out.println("It's a draw match, Thanks for playing");
        } else {
            System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
        }
    }

    void choiceMethod() {
        System.out.println(" Enter 1: To choose 'X'");
        System.out.println(" Enter 2: TO choose 'O'");
        int input = sc.nextInt();
        userChoice = choice[input - 1];
        System.out.println("player choose : " + userChoice);
        if (userChoice == 'X') {
            userChoice = 'X';
            cpuChoice = 'O';
        } else {
            cpuChoice = 'X';
        }
        System.out.println("Computer choose : " + cpuChoice);
    }

    private String tossMethod() {
        System.out.println(" Enter 1: To play first");
        System.out.println(" Enter 2: To play second");
        int toss = sc.nextInt();
        int random = (int) (Math.random() * 2) + 1;
        if (toss == random) {
            play = "user";
            return play;
        }
        play = "computer";
        return play;
    }

    char turn;

    public void printBoard() {
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");

    }

    public void showBoard() {
        int slot = sc.nextInt();
        if (board[slot - 1] == '-') {
            board[slot - 1] = userChoice;
            printBoard();
            winner = checkWinner();
            play = "computer";
        } else {
            System.out.println("Slot already book;please re-enter again");
        }
    }

    public void cpuBoard() {
        int cpuSlot = (int) (Math.random() * 9);
        if (board[cpuSlot] == '-') {
            board[cpuSlot] = cpuChoice;
            printBoard();
            winner = checkWinner();
            play = "user";
        } else {
            System.out.println("Server down;please wait");
        }

    }

    private String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + "" + board[1] + "" + board[2];
                    break;
                case 1:
                    line = board[3] + "" + board[4] + "" + board[5];
                    break;
                case 2:
                    line = board[6] + "" + board[7] + "" + board[8];
                    break;
                case 3:
                    line = board[0] + "" + board[3] + "" + board[6];
                    break;
                case 4:
                    line = board[1] + "" + board[4] + "" + board[7];
                    break;
                case 5:
                    line = board[2] + "" + board[5] + "" + board[8];
                    break;
                case 6:
                    line = board[0] + "" + board[4] + "" + board[8];
                    break;
                case 7:
                    line = board[2] + "" + board[4] + "" + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i] == '-') {
                break;
            } else if (i == 8) {
                String draw = "draw";
                return draw;
            }
        }
        return null;
    }
}

