

/* Name : Surabhi Chavan
Program : Checkers Board
Date : 04/26/2017
 */


import java.util.Scanner;

public class CheckersBoard {

    GamePiece[][] board;
    private static final int dimension = 8;

    //Constructor  
    public CheckersBoard() {
    	
  board = new GamePiece[8][8];
    	int i,j;

        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
            	
                if ((i == 1 && j % 2 == 0)|| ((i == 0 || i == 2) && j % 2 == 1)) {
                    board[i][j] = new GamePiece('B');
                }

                else if (((i == 5 || i == 7) && j % 2 == 0) || (i == 6 && j % 2 == 1)){
                    board[i][j] = new GamePiece('R');
                }

                else {
                    board[i][j] = new GamePiece('-');
                }
            }
        }
    }
    

    public static void main(String[] args) {
        CheckersBoard newBoard = new CheckersBoard();
        System.out.println("Here is your checkers board : \n ");
        newBoard.print();
        newBoard.input();
    }

    //Checks if the destination entered is Valid 
    public void checkIfValid(int r, int c, int des1, int des2) {

        if (des1 == r + 1 && des2 == c + 1) {
            move(r, c, des1, des2);
        } else if (des1 == r - 1 && des2 == c - 1) {
            move(r, c, des1, des2);
        } else if (des1 == r + 1 && des2 == c - 1) {
            move(r, c, des1, des2);
        } else if (des1 == r - 1 && des2 == c + 1) {
            move(r, c, des1, des2);

        }
        else {
        	System.out.println("Please enter a correct row and column number");
        	input();
        }

    }

    //Performs the move
    public void move(int r, int c, int des1, int des2) {
        board[des1][des2].pieceColor = board[r][c].pieceColor;
        board[r][c].pieceColor = '-';
        print();
        continuePlay();
    }

    //Checks if the user wants to continue playing
    public void continuePlay() {
        int c;
        System.out.println("Do you wish to continue ? (Type '1' for Yes and '2' for No)");
        Scanner input = new Scanner(System.in);
        c = input.nextInt();
        if (c == 1) {
            input();

        } else if (c != 2) {
            System.out.println("Please Enter 1 for Yes and 2 for No");
            continuePlay();
        }

    }

    //Takes input from the user
    private void input() {
        Scanner input = new Scanner(System.in);
        int r, c;
        int des1, des2;
        System.out.println("Enter the row number of piece : ");
        r = input.nextInt();
        System.out.println("Enter the column number of piece : ");
        c = input.nextInt();
        if (board[r][c].pieceColor != 'R' && board[r][c].pieceColor != 'B') {
            System.out.println("Please enter a correct row and column number");
            input();
        } else if (board[r][c].pieceColor == 'R') {
            System.out.println("You have selected a Red Piece");

        } else {
            System.out.println("You have selected a Black Piece");
        }

        System.out.println("Enter the row number of destination : ");
        des1 = input.nextInt();
        System.out.println("Enter the column number of destination : ");
        des2 = input.nextInt();
        if (board[des1][des2].pieceColor != '-') {

            System.out.println("Please enter a correct row and column number");

            input();

        }
        checkIfValid(r,c,des1,des2);
    }

    //Displays the Checkers Board
    private void print() {
        for (int i = 0; i <= 7; i++) {
            System.out.print("\n");
            for (int j = 0; j <= 7; j++) {
                System.out.printf("%12s ", board[i][j].pieceColor);

            }
        }
        System.out.println("\n");
    }
    
    
    }

