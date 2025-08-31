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
        int columnSize = getColumnSize(content);

        System.out.println("Table content");
        printLineSeparator(columnSize, false);
        columns
                .forEach(
                        column -> System.out.printf("|%-" + getColumnSize(content) + "s", column)
                );

        printLineSeparator(columnSize, true);
        content.forEach((key, values) -> {
            System.out.printf("|%-" + columnSize + "s", key);
            values.forEach(value -> System.out.printf("|%-" + columnSize + "s", value));
            printLineSeparator(columnSize, true);
        });
    }

    private int getColumnSize(Map<K, List<V>> content) {
        int maxColumnSize = columns.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        int maxKeySize = content.keySet().stream().map(Object::toString)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        int maxValueSize = content.values().stream().flatMap(List::stream).map(Object::toString)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        return Math.max(maxColumnSize, Math.max(maxKeySize, maxValueSize));
    }

    private void printLineSeparator(int columnSize, boolean printPipe) {
        if (printPipe) {
            System.out.println("|");
        }
        for (int i = 0; i < columnSize * columns.size() + columns.size() + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
