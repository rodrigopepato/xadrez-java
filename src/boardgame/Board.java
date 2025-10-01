package boardgame;

public class Board {

    private Integer rows;
    private Integer colmns;
    private Piece[][] pieces;

    public Board() {
    }

    public Board(Integer rows, Integer colmns) {
        this.rows = rows;
        this.colmns = colmns;
        pieces = new Piece[rows][colmns];
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getColmns() {
        return colmns;
    }

    public void setColmns(Integer colmns) {
        this.colmns = colmns;
    }
}
