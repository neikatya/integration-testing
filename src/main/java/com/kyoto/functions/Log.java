package com.kyoto.functions;

import lombok.Setter;

@Setter
public class Log extends SeriesFunction {
    private Ln ln;
    private final double base;
    public Log(int seriesLength, double base) {
        super(seriesLength);
        ln = new Ln(seriesLength);
        this.base = ln.apply(base);
    }

    @Override
    public Double apply(Double d) {
        return ln.apply(d) / base;
    }
}
