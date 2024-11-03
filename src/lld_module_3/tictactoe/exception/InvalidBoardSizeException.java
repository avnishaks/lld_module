package lld_module_3.tictactoe.exception;


public class InvalidBoardSizeException extends RuntimeException{
    public InvalidBoardSizeException() {
    }

    public InvalidBoardSizeException(String message) {
        super(message);
    }
}
