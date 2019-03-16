import java.util.*;

public class Twenty48 {
    private List<List<Integer>> board;
    private List<Integer> availablePoints;
    private int boardSize;

    public Twenty48(int boardSize) {
        this.board = new ArrayList<>(boardSize);
        this.availablePoints = new ArrayList<>(Arrays.asList(2));
        this.boardSize = boardSize;
    }

    public void initBoard() {
        this.board.add(Arrays.asList(0,0,0,0,0));
        this.board.add(Arrays.asList(0,0,0,0,0));
        this.board.add(Arrays.asList(0,0,0,0,0));
        this.board.add(Arrays.asList(0,0,0,0,0));
        this.board.add(Arrays.asList(0,0,0,0,0));
    }

    private static void updateNumbers(List<Integer> row) {
        for (int i = 0; i < row.size() - 1; i++)
            for (int j = i + 1; j < row.size(); j++) {
                if (row.get(i).equals(0)) {
                    row.set(i, row.get(j));
                    row.set(j, 0);
                }
                if (row.get(i).equals(row.get(j))) {
                    row.set(i, row.get(i) * 2);
                    row.set(j, 0);
                }
            }
    }

    public void printBoard() {
        this.board.forEach(row -> {
            row.forEach(element -> System.out.print(String.format("     %s", element)));
            System.out.println("\n\n");
        });
    }

    public List<Integer> getNewBoardNumbers() {
        Integer firstRandom = this.availablePoints.get((int) (Math.random() * this.availablePoints.size()));
        Integer secondRandom = this.availablePoints.get((int) (Math.random() * this.availablePoints.size()));
        Integer thirdRandom = this.availablePoints.get((int) (Math.random() * this.availablePoints.size()));
        return new ArrayList<>(Arrays.asList(firstRandom, secondRandom, thirdRandom));
    }

    public List<List<Integer>> getPlacesToPutNewNumbers() {
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
        List<Integer> boardNumbers = getNewBoardNumbers();
        List<List<Integer>> places = getPlacesToPutNewNumbers();
        places.forEach(coordinates -> {
            this.board.get(coordinates.get(0)).set(coordinates.get(1), boardNumbers.get(0));
            boardNumbers.remove(0);
        });
    }

    private void transpose() {
        for (int i = 0; i < this.board.size(); i++)
            for (int j = i + 1; j < this.board.size(); j++) {
                int temp = this.board.get(i).get(j);
                int temp2 = this.board.get(j).get(i);

                this.board.get(j).set(i, temp);
                this.board.get(i).set(j, temp2);
            }
    }

    public void moveLeft() {
        this.board.forEach(Twenty48::updateNumbers);
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
