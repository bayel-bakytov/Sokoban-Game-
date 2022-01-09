public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int[][] arrayIndexsGoals;
    private int indexX;
    private int indexY;
    private Levels levels;
    private boolean isOk;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        isOk = true;
        levels = new Levels();
        desktop = levels.nextLevel();
        initialization();
    }

    public void initialization() {
        int countFour = 0;
        int countOne = 0;
        int countThree = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    countOne = countOne + 1;
                    indexX = i;
                    indexY = j;
                } else if (desktop[i][j] == 3) {
                    countThree = countThree + 1;
                 } else if (desktop[i][j] == 4) {
                    countFour = countFour + 1;
                } 
            }
        }
        if (countOne != 1 || countThree == 0 || countFour == 0 || countFour != countThree) {
            isOk = false;
            return;
        }
        arrayIndexsGoals = new int[2][countFour];
        int a = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 4) {
                    arrayIndexsGoals[0][a] = i;
                    arrayIndexsGoals[1][a] = j;
                    a++;
                }
            }
        }
    }

    public boolean getIsOk() {
        return isOk;
    }

    public void move(String direction) {
        if (direction.equals("Up")) {
            moveUp();  
        } else if (direction.equals("Right")) {
            moveRight();
        } else if (direction.equals("Down")) {
            moveDown();
        } else if (direction.equals("Left")) {
            moveLeft();
        } else {
            return;
        }
        checkGoals();
        viewer.update();
        won();
    }

    private void checkGoals() {
        for (int i = 0; i < arrayIndexsGoals[0].length; i++) {
            int a = arrayIndexsGoals[0][i];
            int b = arrayIndexsGoals[1][i];
            if (desktop[a][b] == 0) {
                desktop[a][b] = 4;
                break;
            }
        }
    }

    private void won() {
        boolean isWon = true;
        for (int i = 0; i < arrayIndexsGoals[0].length; i++) {
            int k = arrayIndexsGoals[0][i];
            int x = arrayIndexsGoals[1][i];
            if (desktop[k][x] == 4 || desktop[k][x] == 1) {
                isWon = false;
                break;
            }
        }
        if (isWon) {
            viewer.showDialogWon();
            desktop = null;
            desktop = levels.nextLevel();
            initialization();
            viewer.update();
        }
    }

    private void chooseLevel(int level) {
        levels.setLevel(level);   
        desktop = null;  
        desktop = levels.nextLevel();
        initialization();
        viewer.update();
    }

    public void changeLevel(String command) {
            if (command.equals("Level 1")) {
                chooseLevel(1);
            } else if (command.equals("Level 2")) {
                chooseLevel(2);
            } else if (command.equals("Level 3")) {
                chooseLevel(3);
            } else if (command.equals("Level 4")) {
                chooseLevel(4);
            } else if (command.equals("Level 5")) {
                chooseLevel(5);
            } else if (command.equals("Level 6")) {
                chooseLevel(6);
            } else if (command.equals("Level 7")) {
                chooseLevel(7);
            } else if (command.equals("Level 8")) {
                chooseLevel(8);
            } else if (command.equals("Level 9")) {
                chooseLevel(9);
            } else if (command.equals("Exit")) {
                exitGame();
            } else if (command.equals("Restart")) {
                chooseLevel(levels.getLevel() - 1);
            }
    }   

    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }

        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }

        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }

        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }

        if (desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
        } 
    }

    public int[][] getDesktop() {
        return desktop;
    }

    private void exitGame() {
        System.exit(1);
    }

}