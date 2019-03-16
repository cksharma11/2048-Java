package com.step.twenty48;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Twenty48Test {

    Twenty48 twenty48;
    @BeforeEach
    void setUp() {
        twenty48 = new Twenty48(3);
    }

    @Test
    void initBoard() {
        List<List<Integer>> initialBoard = new ArrayList<>();

        initialBoard.add(Arrays.asList(0,0,0));
        initialBoard.add(Arrays.asList(0,0,0));
        initialBoard.add(Arrays.asList(0,0,0));

    }

    @Test
    void printBoard() {
    }
    

    @Test
    void getRandom() {
    }

    @Test
    void getNewCellPositions() {
    }

    @Test
    void updateBoard() {
    }

    @Test
    void moveLeft() {
    }

    @Test
    void moveRight() {
    }

    @Test
    void moveUp() {
    }

    @Test
    void moveDown() {
    }
}