package edu.kenzh.diplom.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Map;

public class ElGamalProblem extends AbstractProblem {
    @Override
    public String getCondition() {
        return "Даны некоторые из параметров шифра Эль-Гамаля, " +
                "а также два сообщения Mab и Mba, первое из которых передается от абонента A абоненту B, " +
                "а второе - от абонента B абоненту A. Параметр Kab - это случайное число, выбираемое абонентом A, " +
                "а Kba - это случайное число, выбираемое абонентом B. Вычислите недостающие параметры шифра " +
                "и выполните все шаги работы данного шифра по передаче обоих сообщений. Убедитесь, что отправленные сообщения " +
                "совпадают с полученными.";
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
        return new SimpleStringProperty("Шифр Эль-Гамаля");
    }
}
