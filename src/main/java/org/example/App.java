package org.example;

import org.example.entity.result.Result;
import org.example.entity.result.comparator.ScoreResultComparator;
import org.example.provider.DataProvider;
import org.example.provider.FileDataProviderImpl;
import org.example.renderer.DataRenderer;
import org.example.renderer.FileDataRenderer;

import java.util.List;

public class App {

    private static final String INPUT_FILE = "src/main/resources/in.txt";
    private static final String OUTPUT_FILE = "src/main/resources/out.txt";

    public static void main( String[] args ) {
        DataProvider dataProvider = new FileDataProviderImpl(INPUT_FILE);
        List<Result> resultList = dataProvider.getResultList();

        resultList.sort(new ScoreResultComparator());

        DataRenderer dataRenderer = new FileDataRenderer(OUTPUT_FILE);
        dataRenderer.render(resultList);
    }
}
