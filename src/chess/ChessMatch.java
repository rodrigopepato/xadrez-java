package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private final Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetUp();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColmns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColmns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }            
        }
        return mat;
    }

    private void  placeNewPiece (char colunm, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(colunm, row).toPosition());
    }

    private void initialSetUp() {
        placeNewPiece('b', 6, new King(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
    }
}
