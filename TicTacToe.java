import java.util.Scanner; 



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); 

        char[][] grid = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} }; // Create a 3x3 grid filled with spaces. char[][] grid: This declares a 2D array named grid that holds characters (chars). It represents the game board where players place their marks ('X' or 'O').

        boolean playerX = true; // This declares a boolean variable named playerX and initializes it to true. This variable is used to track whose turn it is in the game. When playerX is true, it means it's player X's turn to make a move. When playerX is false, it means it's player O's turn.

        boolean gameWon = false; // This declares another boolean variable named gameWon and initializes it to false. This variable is used to track whether the game has been won by any player. Initially, the game has not been won, so gameWon is set to false. When a player wins the game, this variable will be set to true to indicate that the game has been won.



        while (!gameWon && !isDraw(grid)) { // This is a while loop that continues executing as long as two conditions are true

            printGrid(grid); // Print the current state of the grid

            char currentPlayer; // Variable to hold the current player's mark (either 'X' or 'O')

            if (playerX) { // Check if it's player X's turn

                currentPlayer = 'X'; // If it's player X's turn, assign 'X' to currentPlayer

            } else {

                currentPlayer = 'O'; // If it's player O's turn, assign 'O' to currentPlayer

            }

            System.out.println("Player " + currentPlayer + ", enter row (0, 1, or 2): "); // Prompt user for row input

            int row = scanner.nextInt(); // Read the row number input by the user

            System.out.println("Player " + currentPlayer + ", enter column (0, 1, or 2): "); // Prompt user for column input

            int col = scanner.nextInt(); // Read the column number input by the user



            if (row < 0 || row > 2 || col < 0 || col > 2 || grid[row][col] != ' ') { // Check if the move is invalid

                System.out.println("Invalid move. Try again."); // Inform the user the move is invalid

                continue; // Skip the rest of the loop and ask for input again

            }



            grid[row][col] = currentPlayer; // places the current player's mark ('X' or 'O') in the specified position on the game grid, indicating that the current player has made a move in that cell.



            if (checkWin(grid, currentPlayer)) { // Check if the current player has won

                printGrid(grid); // Print the final state of the grid

                System.out.println("Congratulations! Player " + currentPlayer + " has won!"); // Announce the winner

                gameWon = true; // Set gameWon to true to end the game

            } else if (isDraw(grid)) { // If there is no winner, check if the game is a draw

                printGrid(grid); // Print the final state of the grid

                System.out.println("The game is a draw!"); // Announce the draw

                break; // Exit the loop if it's a draw

            }



            if (playerX) {

                playerX = false; // If it was player X's turn, switch to player O's turn

            } else {

                playerX = true; // If it was player O's turn, switch to player X's turn

            }

        }



        scanner.close(); 

    }



    public static void printGrid(char[][] grid) { // Method to print the grid

        for (int i = 0; i < grid.length; i++) { // Loop through each row in the grid

            char[] row = grid[i]; // Get the current row

            for (int j = 0; j < row.length; j++) { // Loop through each cell in the row

                char cell = row[j]; // Get the current cell

                System.out.print(cell + " "); // Print the cell followed by a space

            }

            System.out.println(); // Move to the next line after printing a row

        }

    }





    public static boolean checkWin(char[][] grid, char player) { // Method to check if the player has won

        // Check rows and columns for a win

        for (int i = 0; i < 3; i++) { //check each row and column of the grid.

            if ((grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) || 

                (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player)) { //This is an if statement that checks if either a row or a column is filled with the player's mark.

                return true; // Return true if a row or column is filled by the player

            }

        }

        // Check diagonals for a win

        if ((grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) || 

            (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player)) {

            return true; // Return true if any diagonal is filled by the player

        }

        return false; // Return false if no winning condition is met

    }



    public static boolean isDraw(char[][] grid) { // Method to check if the game is a draw

        for (int i = 0; i < grid.length; i++) { // Loop through each row in the grid

            char[] row = grid[i]; // Get the current row

            for (int j = 0; j < row.length; j++) { // Loop through each cell in the row

                char cell = row[j]; // Get the current cell

                if (cell == ' ') { // If the cell is empty

                    return false; // The game is not a draw

                }

            }

        }

        return true; // If all cells are filled, the game is a draw

    }



}

