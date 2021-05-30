package censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.stream.StreamSupport;

/**
 * @description create Class for Defining the Indian States Census Data
 *
 */
public class CensusAnalyser {
    /**
     * @description create Method for load Indian State census Data into file
     *
     */
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
            Iterable<IndiaCensusCSV> csvIterable = () -> censusCSVIterator;
            int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;
        } catch (InputMismatchException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.DELIMITER_INCORRECT_PROBLEM);
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}
