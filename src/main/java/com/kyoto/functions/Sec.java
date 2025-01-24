package com.kyoto.functions;

import lombok.Setter;

@Setter
public class Sec extends SeriesFunction{
    private Cos COS;
    public Sec(int seriesLength) {
        super(seriesLength);
        COS = new Cos(seriesLength);
    }

    @Override
    public Double apply(Double d) {
        return 1/COS.apply(d);
    }
}
