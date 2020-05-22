package org.example.renderer;

import lombok.extern.java.Log;
import org.example.entity.result.Result;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Log
public class FileDataRenderer implements DataRenderer {

    private String filename;

    public FileDataRenderer(String filename) {
        this.filename = filename;
    }

    @Override
    public void render(List<Result> results) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, false))) {
            log.info("Writing data to output file [" + filename + "]...");

            results.forEach(x -> writer.println(x.getName() + '\t' + x.getTeam() + '\t' + x.getScore()));
        } catch (IOException e) {
            log.warning("Error while writing to output file [" + filename + "]");
            log.warning(e.getMessage());
        }
        log.info("Data successfully written!");
    }
}
