package com.kyoto;

import com.kyoto.functions.*;
import com.kyoto.util.CsvGraphWriter;

public class Main {
    public static void main(String[] args) {
        EquationsSystem equationsSystem = new EquationsSystem(20);
        new CsvGraphWriter(equationsSystem).write(-1.0,1.0, 0.01);
    }
}
