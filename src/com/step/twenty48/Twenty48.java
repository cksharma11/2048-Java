package com.step.twenty48;

import java.util.*;

public class Twenty48 {
    private List<List<Integer>> board;
    private int boardSize;

    public Twenty48(int boardSize) {
        this.board = new ArrayList<>(boardSize);
        this.boardSize = boardSize;
        this.initBoard();
    }

    public void initBoard() {
        for (int rowIndex = 0; rowIndex < boardSize; rowIndex++) {
            List<Integer> row = new ArrayList<>();
            for (int colIndex = 0; colIndex < boardSize; colIndex++) {
                row.add(0);
            }
            this.board.add(row);
        }
    }

    private static void updateCellNumberAndPosition(List<Integer> row) {
        for (int rowIndex = 0; rowIndex < row.size() - 1; rowIndex++) {
            for (int colIndex = 0; colIndex < row.size()-1; colIndex++) {
                if (row.get(colIndex).equals(0)) {
                    row.set(colIndex, row.get(colIndex+1));
                    row.set(colIndex+1, 0);
                }
            }
            if (row.get(rowIndex).equals(row.get(rowIndex + 1))) {
                row.set(rowIndex, row.get(rowIndex) * 2);
                row.set(rowIndex + 1, 0);
            }
        }
    }

    public void printBoard() {
        this.board.forEach(row -> {
            row.forEach(element -> System.out.print(String.format("     %s", element)));
            System.out.println("\n\n");
        });
    }

    public int getRandom(int upperLimit) {
        return (int) (Math.random() * upperLimit);
    }

    public List<Integer> getNewCellPosition() {
        List<Integer> position = new ArrayList<>();
        do {
            int row = getRandom(boardSize);
            int column = getRandom(boardSize);
            boolean isCellEmpty = this.board.get(row).get(column).equals(0);
            if (isCellEmpty) position.addAll(Arrays.asList(row, column));
        } while (position.size() != 2);
        return position;
    }

    public void updateBoard() {
        List<Integer> cellPosition = getNewCellPosition();
        this.board.get(cellPosition.get(0)).set(cellPosition.get(1), 2);
    }

    private void transpose() {
        for (int rowIndex = 0; rowIndex < this.board.size(); rowIndex++)
            for (int colIndex = rowIndex + 1; colIndex < this.board.size(); colIndex++) {
                int previous = this.board.get(rowIndex).get(colIndex);
                int next = this.board.get(colIndex).get(rowIndex);

                this.board.get(colIndex).set(rowIndex, previous);
                this.board.get(rowIndex).set(colIndex, next);
            }
    }

    public void moveLeft() {
        this.board.forEach(Twenty48::updateCellNumberAndPosition);
    }

    public void moveRight() {
        Collections.reverse(this.board);
        this.board.forEach(Collections::reverse);
        this.moveLeft();
        Collections.reverse(this.board);
        this.board.forEach(Collections::reverse);
    }


    public void moveUp() {
        this.transpose();
        this.moveLeft();
        this.transpose();
    }

    public void moveDown() {
        this.transpose();
        this.moveRight();
        this.transpose();
    }

    public boolean hasWon() {
        return this.board.stream().anyMatch(row -> row.stream().anyMatch(element -> element == 2048));
    }
}
