package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		// using colorful terminal: Git Bash
		// now you must open Git Bash in project's bin
		// had to switch from JDK 11 to JDK 22
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		// if at any point there is a "while(true)"
		// is due to the fact that the checkmate login
		// has not been implemented yet
		
		while(!chessMatch.getCheckMate()) {
			try {
			UI.clearScreen();
			UI.printMatch(chessMatch, captured);
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			boolean[][] possibleMoves = chessMatch.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(chessMatch.getPieces(), possibleMoves);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			
			if( capturedPiece != null) {
				captured.add(capturedPiece);
			}
			
			if(chessMatch.getPromoted() != null) {
				System.out.print("\nEnter piece for promotion (B/N/R/Q): ");
				String type = sc.nextLine().toUpperCase();
				while (!type.equals("B") && !type.equals("N") && !type.equals("R") & !type.equals("Q")) {
					System.out.print("\nInvalid value! Enter piece for promotion (B/N/R/Q): ");
					type = sc.nextLine().toUpperCase();
				}
				chessMatch.replacePromotedPiece(type);
			}
			
			}
			catch (ChessException e) {
		        System.out.println(e.getMessage());
		        sc.nextLine();
		    } 
		    catch (InputMismatchException ime) {
		        System.out.println(ime.getMessage());
		        sc.nextLine();
		    }
		    catch (Exception e) {
		        System.out.println("Unexpected error: " + e);
		        e.printStackTrace();
		        sc.nextLine();
		    }
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		// UI.printBoard(chessMatch.getPieces());
	}

}
