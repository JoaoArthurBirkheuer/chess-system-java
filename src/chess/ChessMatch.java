package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] m = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows(); i++)
		{
			for(int j=0; j<board.getColumns(); j++)
			{
				m[i][j] = (ChessPiece)board.piece(i,j);
			}
		}
		return m;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece) capturedPiece;
	}
	
	private void validateTargetPosition(Position source, Position target) {
		// TODO Auto-generated method stub
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}

	private void validateSourcePosition(Position p) {
		if(!board.thereIsAPiece(p)) {
			throw new ChessException("There is no piece on source position");
			// BoardException is also a ChessException
		}
		if(!board.piece(p).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private Piece makeMove(Position src, Position trgt) {
		Piece p = board.removePiece(src);
		Piece capturedPiece = board.removePiece(trgt);
		board.placePiece(p, trgt);
		return capturedPiece;
	}
	
	private void placeNewPiece(Character column, Integer row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
	}
	private void initialSetup() { 
		// from placePiece to placeNewPiece
		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
