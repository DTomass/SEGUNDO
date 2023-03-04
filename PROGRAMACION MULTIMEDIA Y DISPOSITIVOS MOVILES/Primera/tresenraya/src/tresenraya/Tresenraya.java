/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;
import java.util.Scanner;

public class Tresenraya {
  static char[][] board = new char[3][3];
  static Scanner input = new Scanner(System.in);
  static char currentPlayer = 'X';

  public static void main(String[] args) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = ' ';
      }
    }
    play();
  }

  public static void play() {
    boolean playing = true;
    while (playing) {
      printBoard();
      System.out.println("Player " + currentPlayer + ", enter your move (row column): ");
      int row = input.nextInt() - 1;
      int column = input.nextInt() - 1;
      board[row][column] = currentPlayer;
      if (gameOver(row, column)) {
        playing = false;
        System.out.println("Player " + currentPlayer + " wins!");
      } else {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
      }
    }
  }

  public static boolean gameOver(int row, int column) {
    // check for win in row
    for (int i = 0; i < 3; i++) {
      if (board[row][i] != currentPlayer) {
        break;
      }
      if (i == 2) {
        return true;
      }
    }
    // check for win in column
    for (int i = 0; i < 3; i++) {
      if (board[i][column] != currentPlayer) {
        break;
      }
      if (i == 2) {
        return true;
      }
    }
    // check for win on diagonal
    if (row == column) {
      for (int i = 0; i < 3; i++) {
        if (board[i][i] != currentPlayer) {
          break;
        }
        if (i == 2) {
          return true;
        }
      }
    }
    if (row + column == 2) {
      for (int i = 0; i < 3; i++) {
        if (board[i][2 - i] != currentPlayer) {
          break;
        }
        if (i == 2) {
          return true;
        }
      }
    }
    return false;
  }

  public static void printBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + "|");
      }
      System.out.println();
      System.out.println("---------");
    }
  }
}

