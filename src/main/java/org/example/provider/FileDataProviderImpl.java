package org.example.provider;

import lombok.extern.java.Log;
import org.example.entity.result.Result;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log
public class FileDataProviderImpl implements DataProvider {

    private String filename;

    public FileDataProviderImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Result> getResultList() {
        List<Result> results = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            log.info("Reading input file [" + filename + "]...");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                results.add(parseLine(line));
            }
        } catch (IOException e) {
            log.warning("Error while reading input file [" + filename + "]");
            log.warning(e.getMessage());
        }
        log.info("Input file successfully read!");
        return results;
    }

    private Result parseLine(String line) {
        String[] splittedLine = line.split("\\t");
        Result result = new Result();
        result.setName(splittedLine[0]);
        result.setTeam(splittedLine[1]);
        result.setScore(Integer.parseInt(splittedLine[2]));
        return result;
    }
}
