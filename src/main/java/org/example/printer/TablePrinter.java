package org.example.printer;

import java.util.List;
import java.util.Map;

public class TablePrinter<K, V> implements Printer<Map<K, List<V>>> {

    private final List<String> columns;

    public TablePrinter(List<String> columns) {
        this.columns = columns;
    }

    @Override
    public void print(Map<K, List<V>> content) {
        if (content == null || content.isEmpty()) {
            System.out.println("No data to print.");
            return;
        }

        System.out.println("Table content");
        printLineSeparator(false);
        columns.forEach(column -> System.out.printf("|%-" + getColumnSize() + "s", column));

        printLineSeparator(true);
        content.forEach((key, values) -> {
            System.out.printf("|%-" + getColumnSize() + "s", key);
            values.forEach(value -> System.out.printf("|%-" + getColumnSize() + "s", value));
            printLineSeparator(true);
        });
    }

    private int getColumnSize() {
        return columns.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    private void printLineSeparator(boolean printPipe) {
        if (printPipe) {
            System.out.println("|");
        }
        for (int i = 0; i < getColumnSize() * columns.size() + columns.size() + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
