package lld_module_3.tictactoe.exception;


public class InvalidNumberOfPlayersException extends RuntimeException{
    public InvalidNumberOfPlayersException() {
    }

    public InvalidNumberOfPlayersException(String message) {
        super(message);
    }
}
