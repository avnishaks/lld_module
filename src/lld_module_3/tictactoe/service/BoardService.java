package lld_module_3.tictactoe.service;

import lld_module_3.tictactoe.models.Board;
import lld_module_3.tictactoe.models.Cell;

import java.util.List;

public class BoardService {
    public void printBoard(Board board){
        List<List<Cell>> cells = board.getCells();
        for(int i=0;i<board.getSize();i++){
            List<Cell> row = cells.get(i);
            for(Cell cell : row){
                if(cell.getPlayer() == null){
                    System.out.print("|X| ");
                } else {
                    System.out.print("|" + cell.getPlayer().getSymbol() + "| ");
                }
            }
            System.out.println();
        }
    }
}
