package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// using colorful terminal: Git Bash
		// now you must open Git Bash in project's bin
		// had to switch from JDK 11 to JDK 22
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
	}

}
