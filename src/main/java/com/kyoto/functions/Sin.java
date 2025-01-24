package com.kyoto.functions;

import lombok.Setter;

@Setter
public class Sin extends SeriesFunction{
    private Cos COS;
    public Sin(int seriesLength) {
        super(seriesLength);
        COS = new Cos(seriesLength);
    }

    @Override
    public Double apply(Double d) {
        // sin(x) = cos(π/2 - x)
        return COS.apply(Math.PI / 2 - d);
    }
}
