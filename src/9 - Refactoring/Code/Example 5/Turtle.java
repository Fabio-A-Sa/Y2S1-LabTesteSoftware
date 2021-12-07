package pt.up.fe.ldts.example5;

import javax.swing.plaf.basic.BasicComboBoxUI;

public class Turtle {

    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void execute(char command) {

        if (command == 'F') {
            switch (direction) {
                case 'N':
                    row--;
                    break;
                case 'S':
                    row++;
                    break;
                case 'W':
                    column--;
                    break;
                case 'E':
                    column++;
                    break;
                default:
                    return;
            }
        } else {
            switch (direction) {
                case 'N':
                    direction = command == 'L' ? 'W' : 'E';
                    break;
                case 'S':
                    direction = command == 'L' ? 'E' : 'W';
                    break;
                case 'W':
                    direction = command == 'L' ? 'S' : 'N';
                    break;
                case 'E':
                    direction = command == 'L' ? 'N' : 'S';
                    break;
                default:
                    return;
            }
        }
    }
}
