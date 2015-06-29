package edu.kenzh.diplom.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Map;

public class FullEnumProblem extends AbstractProblem {
    @Override
    public String getCondition() {
        return "Дано число n, которое является произведением двух простых чисел p и q. " +
                " Методом полного перебора найдите эти числа. ";
    }

    @Override
    public Map<String, Integer> getSolution() {
        return null;
    }

    @Override
    public boolean generate() {
        return false;
    }

    @Override
    public StringProperty getName() {
        return new SimpleStringProperty("Метод полного перебора");
    }
}
