package lesson1;

import java.util.Random;

class Homework {

    private char[][] game;

    private int[] currentCoordinates;

    private int hp;

    private boolean gameOver;


    Homework() {
        this.game = new char[15][15];
        this.currentCoordinates = new int[]{0, 0};
        this.hp = 100;
        this.gameOver = false;

        this.initializeGameBoard();
        this.initializeBombs();
        this.initializeAids();
        this.render();

    }

    private void initializeGameBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                this.game[i][j] = '_';
            }
        }
    }

    private void initializeBombs() {
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            boolean found = false;
            while (!found) {
                int position = random.nextInt(15);
                if (this.game[i][position] == '_') {
                    this.game[i][position] = '*';
                    found = true;
                }
            }
        }
    }

    private void initializeAids() {
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            boolean found = false;
            while (!found) {
                int position = random.nextInt(15);
                if (this.game[i][position] == '_') {
                    this.game[i][position] = '+';
                    found = true;
                }
            }
        }
    }

    private void render() {
        this.game[this.currentCoordinates[0]][this.currentCoordinates[1]] = '@';
        this.game[14][14] = '!';
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(" " + this.game[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    boolean isGameFinish() {
        return this.gameOver;
    }

    int getHp() {
        return this.hp;
    }

    void move(char key) {
        this.game[this.currentCoordinates[0]][this.currentCoordinates[1]] = '_';

        switch (key) {
            case 'a':
                this.moveLeft();
                break;
            case 'd':
                this.moveRight();
                break;
            case 's':
                this.moveDown();
                break;
            case 'w':
                this.moveUp();
                break;
        }
        this.checkPosition();
        this.checkHp();
        this.render();
    }

    private void checkPosition() {
        switch (game[currentCoordinates[0]][currentCoordinates[1]]) {
            case '*':
                this.hp = this.hp - 20;
                break;
            case '+':
                this.hp = this.hp + 20;
                break;
            case '!':
                this.gameOver = true;
        }
    }

    private void checkHp() {
        if (this.hp <= 0) {
            this.gameOver = true;
        }
    }

    private void moveLeft() {
        int linePosition = currentCoordinates[1];
        if (linePosition == 0) {
            linePosition = 14;
        } else {
            linePosition--;
        }
        currentCoordinates[1] = linePosition;
    }

    private void moveRight() {
        int linePosition = currentCoordinates[1];
        if (linePosition == 14) {
            linePosition = 0;
        } else {
            linePosition++;
        }
        currentCoordinates[1] = linePosition;
    }

    private void moveDown() {
        if (currentCoordinates[0] != 14) {
            currentCoordinates[0] = currentCoordinates[0] + 1;
        }

    }

    private void moveUp() {
        if (currentCoordinates[0] != 0) {
            currentCoordinates[0] = currentCoordinates[0] - 1;
        }
    }
}
