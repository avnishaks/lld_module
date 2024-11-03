package lld_module_3.tictactoe.service;

import lld_module_3.tictactoe.exception.DuplicateSymbolException;
import lld_module_3.tictactoe.models.Player;
import lld_module_3.tictactoe.models.PlayerType;

import java.util.HashSet;

public class PlayerService {
    private static int counter = 1;
    private HashSet<Character> symbolSet;
    public PlayerService() {
        this.symbolSet = new HashSet<>();
    }
    public Player createPlayer(String name, char symbol){
        if(symbolSet.contains(symbol)){
            throw new DuplicateSymbolException("Duplicate symbols are not allowed");
        }
        symbolSet.add(symbol);
        return new Player(
                counter++,
                name,
                symbol,
                PlayerType.HUMAN
        );
    }
}
