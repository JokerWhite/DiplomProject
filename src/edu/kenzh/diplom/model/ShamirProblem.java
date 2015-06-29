package edu.kenzh.diplom.model;

import edu.kenzh.diplom.utils.ExtendedEuclid;
import edu.kenzh.diplom.utils.IntegerUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.*;

public class ShamirProblem extends AbstractProblem {

    int m;
    int p;
    int ca;
    int da;
    int cb;
    int db;
    @Override
    public boolean generate() {
        p = IntegerUtils.generateRandomInt(100);
        m = IntegerUtils.generateRandomInt(p);
        ca = IntegerUtils.generateRandomInt(p);
        cb = IntegerUtils.generateRandomInt(p);
        return true;
    }
 public ShamirProblem() {
     condition = new TreeMap<>();
     generate();
     condition.put("m", m);
     condition.put("p", p);
     condition.put("Ca", ca);
     condition.put("Cb", cb);
 }
    @Override
    public String getCondition() {
            return "Даны некоторые из параметров шифра Шамира и передаваемое сообщение m. " +
                    "Вычислите недостающие параметры и выполните все шаги работы данного шифра. " +
                    "Убедитесь, что отправленное сообщение равно полученному.";
    }

    @Override
    public Map<String, Integer> getSolution() {
        Map<String, Integer> solution = new TreeMap<>();
        int[] x = new int[4];
        if (m!=0){
            solution.put("m",m);
            solution.put("p",p);
            solution.put("Ca",ca);
            solution.put("Cb",cb);
            db = ExtendedEuclid.inverse(p-1, cb);
            da = ExtendedEuclid.inverse(p-1, ca);
            solution.put("Da", da);
            solution.put("Db", db);
            x[0]= (int) (Math.pow(m,ca)%p);
            x[1]= (int) (Math.pow(x[0],cb)%p);
            x[2]= (int) (Math.pow(x[1],da)%p);
            x[3]= (int) (Math.pow(x[2],db)%p);
            for (int i = 0; i < x.length; i++) {
                solution.put("x"+(i+1),x[i]);
            }
        }
        return solution;
    }

    @Override
    public StringProperty getName() {

        return new SimpleStringProperty("Шифр Шамира");
    }
}
