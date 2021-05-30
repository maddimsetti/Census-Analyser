package censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @description create Class for Defining the Indian State Census Data Test
 *
 */
public class CensusAnalyserTest {
    //variables
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String WRONG_TYPE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.txt";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_HEADER_CSV_FILE_PATH = "./src/test/resources/WrongHeaderIndiaStateCensusData.csv";
    private static final String INDIA_STATE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
    private static final String WRONG_STATE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String WRONG_TYPE_STATE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.txt";
    private static final String WRONG_HEADER_STATE_CSV_FILE_PATH = "./src/test/resources/WrongHeaderIndiaStateCode.csv";

    /**
     * @description create Test Method for IndianCensus Data for collecting Records
     *   Param: This a Happy Test Case to check the number of Records Match
     */
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    /**
     * @description create Test Method for Indian Census Data for Wrong File Path
     *  Param: This a Sad Case for Wrong Census CSV file Path Should Throw a custom Exception
     */
    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    /**
     * @description create Test Method for Indian Census Data for Type Incorrect
     *  Param: This a Sad Case for Census CSV file is correct but Type incorrect returns a custom Exception
     */
    @Test
    public void givenIndiaCensusData_WithTypeIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_TYPE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    /**
     * @description create Test Method for Indian Census Data for Delimiter Incorrect
     *  Param: This a Sad Case for Census CSV file is correct but delimiter incorrect returns a custom Exception
     */
    @Test
    public void givenIndiaCensusData_WithDelimiterIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT_PROBLEM,e.type);
        }
    }

    /**
     * @description create Test Method for Indian Census Data for Header Incorrect
     *  Param: This a Sad Case for Census CSV file is correct but Header incorrect returns a custom Exception
     */
    @Test
    public void givenIndiaCensusData_WithHeaderIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_HEADER_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    /**
     * @description create Test Method for Indian Data for collecting Records
     *   Param: This a Happy Test Case to check the number of Records Match
     */
    @Test
    public void givenIndianStateCSV_ShouldReturnExactCount() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfStateCode = censusAnalyser.loadIndiaStateCode(INDIA_STATE_CSV_FILE_PATH);
            Assert.assertEquals(37,numOfStateCode);
        } catch (CensusAnalyserException e) { }
    }

    /**
     * @description create Test Method for Indian State Code for Wrong File Path
     *  Param: This a Sad Case for Wrong State Code CSV file Path Should Throw a custom Exception
     */
    @Test
    public void givenIndiaStateCodes_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_STATE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    /**
     * @description create Test Method for Indian State Code for Type Incorrect
     *  Param: This a Sad Case for State Code CSV file is correct but Type incorrect returns a custom Exception
     */
    @Test
    public void givenIndiaStateCodes_WithTypeIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_TYPE_STATE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    /**
     * @description create Test Method for Indian STATE code for Delimiter Incorrect
     *  Param: This a Sad Case for State Code CSV file is correct but delimiter incorrect returns a custom Exception
     */
    @Test
    public void givenIndiaStateCodes_WithDelimiterIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT_PROBLEM,e.type);
        }
    }

    /**
     * @description create Test Method for Indian State Code for Header Incorrect
     *  Param: This a Sad Case for State Code CSV file is correct but Header incorrect returns a custom Exception
     */
    @Test
    public void givenIndiaStateCodes_WithHeaderIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_HEADER_STATE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
}
