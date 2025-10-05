package metrics;

import java.io.FileWriter;
import java.io.IOException;

/*
 * Utility class for writing benchmark results to a CSV file.
 * Columns: inputType, arraySize, comparisons, swaps, accesses, timeMs
 */
public class BenchmarkCSVExporter {

    private final String filePath;

    public BenchmarkCSVExporter(String filePath) {
        this.filePath = filePath;
    }

    public void writeHeader() throws IOException {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write("inputType,arraySize,comparisons,swaps,arrayAccesses,timeMs\n");
        }
    }

    public void appendResult(String inputType, int arraySize, long comparisons, long swaps, long accesses, double timeMs) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(String.format("%s,%d,%d,%d,%d,%.3f%n",
                    inputType, arraySize, comparisons, swaps, accesses, timeMs));
        }
    }
}
