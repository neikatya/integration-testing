package com.kyoto.functions;

import lombok.Setter;

import static java.lang.Math.pow;

@Setter
public class Cos extends SeriesFunction{
    private Factorial FACTORIAL;
    public Cos(int seriesLength) {
        super(seriesLength);
        FACTORIAL = new Factorial();
    }

    @Override
    public Double apply(Double d) {
        double cosValue = 0;
        for (long i = 0; i <= seriesLength; i++) {
            cosValue += (pow(-1, i) * pow(d, 2*i)) / FACTORIAL.apply(2*i);
        }
        return cosValue;
    }
}
