package com.dev;

import com.dev.model.EcoBike;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static List<? super EcoBike> bikes = new ArrayList<>();

    public static List<? super EcoBike> getBikes() {
        return bikes;
    }
}
