import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Twenty48 twenty48 = new Twenty48();
        twenty48.initBoard();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String move = scanner.nextLine();
            switch (move){
                case "w":
                    twenty48.moveUp();
                    twenty48.updateBoard();
                    twenty48.printBoard();
                    break;
                case "s":
                    twenty48.moveDown();
                    twenty48.updateBoard();
                    twenty48.printBoard();
                    break;
                case "a":
                    twenty48.moveLeft();
                    twenty48.updateBoard();
                    twenty48.printBoard();
                    break;
                case "d":
                    twenty48.moveRight();
                    twenty48.updateBoard();
                    twenty48.printBoard();
                    break;

                    default:
                        System.out.println("Enter correct move");
                        break;
            }
        }
    }
}
