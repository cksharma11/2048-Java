package com.step.twenty48;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Twenty48 twenty48 = new Twenty48(4);
        Scanner scanner = new Scanner(System.in);

        while (!twenty48.hasWon()) {
            twenty48.updateBoard();
            twenty48.printBoard();
            System.out.println("Use these keys to move : w-> up,  s-> down, a-> left, d-> right");
            String move = scanner.nextLine();
            switch (move) {
                case "w":
                    twenty48.moveUp();
                    break;
                case "s":
                    twenty48.moveDown();
                    break;
                case "a":
                    twenty48.moveLeft();
                    break;
                case "d":
                    twenty48.moveRight();
                    break;

                default:
                    System.out.println("Enter correct move");
                    break;
            }
        }

        if(twenty48.hasWon()){
            System.out.println("You won the Game . ");
        }
    }
}
