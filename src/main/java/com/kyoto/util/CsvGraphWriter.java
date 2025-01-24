package com.kyoto.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import lombok.SneakyThrows;

public class CsvGraphWriter {
    private final BufferedWriter writer;
    private final Function<Double, Double> function;

    @SneakyThrows
    public CsvGraphWriter(Function<Double, Double> function) {
        this.writer = new BufferedWriter( new FileWriter(function.getClass().getName() + ".csv"));
        this.function = function;
    }

    @SneakyThrows
    public void write(double begin, double end, double delta) {
        writer.write("x,y\n");
        for (double i = begin; i <= end; i+= delta) {
            writer.write(String.format("%f,%f\n", i, function.apply(i)));
        }
        writer.flush();
    }
}
