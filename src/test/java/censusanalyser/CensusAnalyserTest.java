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
    private static final String WRONG_TYPE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.txt";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";

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
}
