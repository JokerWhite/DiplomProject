package edu.kenzh.diplom.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Map;

public class SameMaxDivisor extends AbstractProblem {
    @Override
    public String getCondition() {
        return "Найдите наибольший общий делитель чисел a и b.";
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
        return new SimpleStringProperty("НОК");
    }
}
