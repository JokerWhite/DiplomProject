package edu.kenzh.diplom.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Map;

public class RsaProblem extends AbstractProblem {
    @Override
    public String getCondition() {
        return "Даны некоторые из параметров шифра RSA для двух абонентов, а также два сообщения Mab и Mba, " +
                "передаваемые соответственно от абонента A абоненту B и от абонента B абоненту A. " +
                "Вычислите недостающие параметры и выполните необходимые шаги по передаче обоих сообщений. " +
                "Убедитесь, что отправленные сообщения совпадают с полученными.";
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
        return new SimpleStringProperty("Шифр RSA");
    }
}
