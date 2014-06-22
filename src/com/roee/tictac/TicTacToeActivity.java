package com.roee.tictac;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends Activity {
	// Buttons making up the board
	private Button mBoardButtons[];

	// Various text displayed
	private TextView mInfoTextView;
	// Correct game
	private TicTacToeGame mGame;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

		mBoardButtons = new Button[9];
		mBoardButtons[0] = (Button) findViewById(R.id.one);
		mBoardButtons[1] = (Button) findViewById(R.id.two);
		mBoardButtons[2] = (Button) findViewById(R.id.three);
		mBoardButtons[3] = (Button) findViewById(R.id.four);
		mBoardButtons[4] = (Button) findViewById(R.id.five);
		mBoardButtons[5] = (Button) findViewById(R.id.six);
		mBoardButtons[6] = (Button) findViewById(R.id.seven);
		mBoardButtons[7] = (Button) findViewById(R.id.eight);
		mBoardButtons[8] = (Button) findViewById(R.id.nine);

		mInfoTextView = (TextView) findViewById(R.id.information);

		mGame = new TicTacToeGame();
		startNewGame();
	}

	// Set up the game board.
	private void startNewGame() {

		mGame.clearBoard();
		// Reset all buttons
		for (int i = 0; i < mBoardButtons.length; i++) {
			mBoardButtons[i].setText("");
			mBoardButtons[i].setEnabled(true);
			mBoardButtons[i].setOnClickListener(new ButtonClickListener(i));
		}
		mInfoTextView.setText("The Game begin");

	}

	// Handles clicks on the game board buttons
	private class ButtonClickListener implements OnClickListener {
		int location;

		public ButtonClickListener(int location) {
			this.location = location;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (mBoardButtons[location].isEnabled()) {
				setMove(TicTacToeGame.LOCAL_PLAYER, location);

				// If no winner yet, let the computer make a move
				int winner = mGame.CheckWin();
				if (winner == 0) {
					//Remote turn
	//				setMove(TicTacToeGame.REMOTE_PLAYER, ?);
					winner = mGame.CheckWin();
				}

				if (winner == 0)
					mInfoTextView.setText("It's your turn.");
				else if (winner == 2)
					mInfoTextView.setText("It's a tie!");
				else if (winner == 1)
					mInfoTextView.setText("You won!");
				else
					mInfoTextView.setText("Remote won!");
				if(winner!=0)
					mGameOver();
			}
		}
		private void mGameOver() {
for(int i=0;i<9;i++)
	mBoardButtons[i].setEnabled(false);
			
		}

		private void setMove(char player, int location) {
		  	mGame.setMove(player, location);
		  	mBoardButtons[location].setEnabled(false); 
		  	mBoardButtons[location].setText(String.valueOf(player));
		  	if (player == TicTacToeGame.LOCAL_PLAYER) 
		  		mBoardButtons[location].setTextColor(Color.rgb(0, 200, 0));     	    
		  	else 
		     	mBoardButtons[location].setTextColor(Color.rgb(200, 0, 0)); 
		}

	}

}