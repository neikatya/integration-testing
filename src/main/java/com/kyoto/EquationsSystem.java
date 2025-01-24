package com.kyoto;

import com.kyoto.functions.Cos;
import com.kyoto.functions.Ln;
import com.kyoto.functions.Log;
import com.kyoto.functions.Sec;
import com.kyoto.functions.SeriesFunction;
import lombok.Setter;

import static java.lang.Math.pow;

@Setter
public class EquationsSystem extends SeriesFunction {
    private Cos COS;
    private Ln LN;
    private Log LOG3;
    private Log LOG5;
    private Log LOG10;
    private Sec SEC;

    protected EquationsSystem(int seriesLength) {
        super(seriesLength);
        this.COS = new Cos(seriesLength);
        this.LN = new Ln(seriesLength);
        this.LOG3 = new Log(seriesLength, 3);
        this.LOG5 = new Log(seriesLength, 5);
        this.LOG10 = new Log(seriesLength, 10);
        this.SEC = new Sec(seriesLength);
    }


    @Override
    public Double apply(Double x) {
        if (x <= 0) {
            return (pow(SEC.apply(x), 3) * COS.apply(x)) + SEC.apply(x);
        } else {
            return pow(((LN.apply(x) - LOG3.apply(x)) - LOG10.apply(x)) / LN.apply(x) + LOG5.apply(x) / LOG10.apply(x), 2);
        }
    }

}
