package com.lab111.labwork7;

public class Menu extends Invocer {

    public Menu(Comand c) {
        super(c);
    }

    public void Action() {
        System.out.println("робота меню");
        super.Action();
    }

}
