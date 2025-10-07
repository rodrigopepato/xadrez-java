package boardgame;

public class Board {

    private Integer rows;
    private Integer colmns;
    private Piece[][] pieces;

    public Board(Integer rows, Integer colmns) {
        if (rows < 1 || colmns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 colmn");
        }
        this.rows = rows;
        this.colmns = colmns;
        pieces = new Piece[rows][colmns];
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColmns() {
        return colmns;
    }

    public Piece piece(int row, int colmn) {
        if (!positionExists(row, colmn)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][colmn];
    }

    public Piece piece(Position position) {
        if (!positionExists(position.getRow(), position.getColumn())) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    private Boolean positionExists(int row, int colmn) {
        return row >= 0 && row < rows && colmn >= 0 && colmn < colmns;
    }

    public Boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public Boolean thereIsAPiece(Position position) {
        if (!positionExists(position.getRow(), position.getColumn())) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
