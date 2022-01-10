package client;

import client.view.GUI;

public class Main {
    private static final String TITLE = "Payments database";

    public static void main(String[] args){
        GUI frame = new GUI(TITLE);
        frame.setVisible(true);
    }
}
