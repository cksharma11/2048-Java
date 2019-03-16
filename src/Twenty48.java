import java.util.*;

public class Twenty48 {
    private List<List<Integer>> board;
    private List<Integer> availablePoints;
    private int boardSize;

    public Twenty48(int boardSize) {
        this.board = new ArrayList<>(boardSize);
        this.availablePoints = new ArrayList<>(Arrays.asList(2));
        this.boardSize = boardSize;
        this.initBoard();
    }

    public void initBoard() {
        this.board.add(Arrays.asList(0,0,0,0,0));
        this.board.add(Arrays.asList(0,0,0,0,0));
        this.board.add(Arrays.asList(0,0,0,0,0));
        this.board.add(Arrays.asList(0,0,0,0,0));
        this.board.add(Arrays.asList(0,0,0,0,0));
    }

    private static void updateCellNumberAndPosition(List<Integer> row) {
        for (int rowIndex = 0; rowIndex < row.size() - 1; rowIndex++)
            for (int colIndex = rowIndex + 1; colIndex < row.size(); colIndex++) {
                if (row.get(rowIndex).equals(0)) {
                    row.set(rowIndex, row.get(colIndex));
                    row.set(colIndex, 0);
                }
                if (row.get(rowIndex).equals(row.get(colIndex))) {
                    row.set(rowIndex, row.get(rowIndex) * 2);
                    row.set(colIndex, 0);
                }
            }
    }

    public void printBoard() {
        this.board.forEach(row -> {
            row.forEach(element -> System.out.print(String.format("     %s", element)));
            System.out.println("\n\n");
        });
    }

    public List<Integer> getNewCellNumbers() {
        Integer firstRandom = this.availablePoints.get((int) (Math.random() * this.availablePoints.size()));
        Integer secondRandom = this.availablePoints.get((int) (Math.random() * this.availablePoints.size()));
        Integer thirdRandom = this.availablePoints.get((int) (Math.random() * this.availablePoints.size()));
        return new ArrayList<>(Arrays.asList(firstRandom, secondRandom, thirdRandom));
    }

    public List<List<Integer>> getNewCellPositions() {
        List<List<Integer>> places = new ArrayList<>();
        int row = (int) (Math.random() * boardSize);
        int column = (int) (Math.random() * boardSize);
        while (places.size() != 3) {
            if (this.board.get(row).get(column) == 0) {
                places.add(Arrays.asList(row, column));
            }
            row = (int) (Math.random() * boardSize);
            column = (int) (Math.random() * boardSize);
        }
        return places;
    }

    public void updateBoard() {
        List<Integer> boardNumbers = getNewCellNumbers();
        List<List<Integer>> places = getNewCellPositions();
        places.forEach(coordinates -> {
            this.board.get(coordinates.get(0)).set(coordinates.get(1), boardNumbers.get(0));
            boardNumbers.remove(0);
        });
    }

    private void transpose() {
        for (int rowIndex = 0; rowIndex < this.board.size(); rowIndex++)
            for (int colIndex = rowIndex + 1; colIndex < this.board.size(); colIndex++) {
                int temp = this.board.get(rowIndex).get(colIndex);
                int temp2 = this.board.get(colIndex).get(rowIndex);

                this.board.get(colIndex).set(rowIndex, temp);
                this.board.get(rowIndex).set(colIndex, temp2);
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
}
