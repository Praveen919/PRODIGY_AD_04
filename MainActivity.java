package com.example.tictactoeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        buttons[0][0] = findViewById(R.id.btn1);
        buttons[0][1] = findViewById(R.id.btn2);
        buttons[0][2] = findViewById(R.id.btn3);
        buttons[1][0] = findViewById(R.id.btn4);
        buttons[1][1] = findViewById(R.id.btn5);
        buttons[1][2] = findViewById(R.id.btn6);
        buttons[2][0] = findViewById(R.id.btn7);
        buttons[2][1] = findViewById(R.id.btn8);
        buttons[2][2] = findViewById(R.id.btn9);
    }

    public void onCellClick(View view) {
        Button clickedButton = (Button) view;
        if (clickedButton.getText().toString().isEmpty()) {
            if (player1Turn) {
                clickedButton.setText("X");
            } else {
                clickedButton.setText("O");
            }
            player1Turn = !player1Turn;
            checkForWin();
        }
    }

    public void onResetClick(View view) {
        // Reset the board and player turn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        player1Turn = true;
    }

    private void checkForWin() {
        String[][] board = new String[3][3];
        // Copy button text to the board array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString();
            }
        }

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].isEmpty() && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                announceWinner(board[i][0]);
                return;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (!board[0][j].isEmpty() && board[0][j].equals(board[1][j]) && board[0][j].equals(board[2][j])) {
                announceWinner(board[0][j]);
                return;
            }
        }

        // Check diagonals
        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            announceWinner(board[0][0]);
            return;
        }

        if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            announceWinner(board[0][2]);
        }
    }

    private void announceWinner(String winner) {
        // Display a toast message or update a TextView to announce the winner
        // For example:
        Toast.makeText(this, winner + " wins!", Toast.LENGTH_SHORT).show();
    }
}
