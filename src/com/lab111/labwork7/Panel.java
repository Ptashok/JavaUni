package com.lab111.labwork7;

public class Panel extends Invocer {

    public Panel(Comand c) {
        super(c);
    }

    public void Action() {
        System.out.println("робота панели");
        super.Action();
    }

}
