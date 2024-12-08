package com.lab111.labwork7;

import java.util.ArrayList;

/**
 * Макро-команда
 *
 */
public class MacroComand implements Comand {
    public MacroComand(Comand c) {
        comand = new ArrayList<Comand>();
        comand.add(c);
    }

    private ArrayList<Comand> comand;

    /*
     * выполнение макро-команды
     */
    public void Execute() {
        System.out.println("Макро-команда");
        for (Comand element : comand)
            element.Execute();
    }

    public void addComand(Comand newComand) {
        comand.add(newComand);
    }

    public void deleteComand(Comand deleteComand) {
        comand.add(deleteComand);
    }

}
