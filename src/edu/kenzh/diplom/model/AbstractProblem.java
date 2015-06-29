package edu.kenzh.diplom.model;

import javafx.beans.property.StringProperty;

import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractProblem {
    public Map<String, Integer> condition = new TreeMap<>();
    public abstract String getCondition();
    public abstract Map<String, Integer> getSolution();
    public abstract boolean generate();
    public abstract StringProperty getName();
}
