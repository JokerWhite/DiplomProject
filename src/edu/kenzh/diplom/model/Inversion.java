package edu.kenzh.diplom.model;

import edu.kenzh.diplom.utils.ExtendedEuclid;
import edu.kenzh.diplom.utils.IntegerUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Map;
import java.util.TreeMap;

public class Inversion extends AbstractProblem {
    int c;
    int m;
    int d;

    public Inversion() {

        generate();
        condition.put("c", c);
        condition.put("m", m);
    }

    @Override
    public String getCondition() {
        return "Найдите инверсию числа c по модулю m методом перебора.";
    }

    @Override
    public Map<String, Integer> getSolution() {
        Map<String,Integer> solution = new TreeMap<>();
        solution.put("c",c);
        solution.put("m",m);
        d = ExtendedEuclid.inverse(m,c);
        solution.put("d",d);
        return solution;
    }

    @Override
    public boolean generate() {
        m = IntegerUtils.generateRandomInt(100);
        c = IntegerUtils.generateRandomInt(m);

        return true;
    }

    @Override
    public StringProperty getName() {
        return new SimpleStringProperty("Инверсия");
    }
}
