package censusanalyser;

/**
 * @description create Class for Defining the Census Analyser Exception
 *
 */
public class CensusAnalyserException extends Exception {
    //Created Enum Exception Type
    enum ExceptionType {
        CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE,DELIMITER_INCORRECT_PROBLEM
    }
    ExceptionType type;
    //Created Custom Exception
    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    //Created custom exception with Parameter
    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
