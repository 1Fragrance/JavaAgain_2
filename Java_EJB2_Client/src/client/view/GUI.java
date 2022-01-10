package client.view;

import client.ServerContext;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GUI extends Frame {

    public GUI(String title) {
        super(title);

        configureWindow();
        configureServerContext();
        configureComponents();
    }

    private ServerContext serverContext;
    private List list;

    private void configureWindow() {
        setLayout(new GridBagLayout());
        setSize(400,400);
        setPreferredSize(getSize());
        addWindowListener(new WindowClose());
        setVisible(true);
    }

    private void configureServerContext() {
        serverContext = new ServerContext();
    }

    private void configureComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        list = new List();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridheight = 3;
        gbc.gridwidth = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(list, gbc);

        Label valueLabel = new Label("Amount");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.05;
        add(valueLabel, gbc);

        TextField valueInput = new TextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(valueInput, gbc);

        Label codeLabel = new Label("Credit code");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(codeLabel, gbc);

        TextField codeInput = new TextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(codeInput, gbc);


        Panel leftPanel = new Panel(new FlowLayout());
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        add(leftPanel, gbc);

        Button addBtn = new Button("Add");
        addBtn.addActionListener(new AddButtonActionListener(list, valueInput, codeInput, serverContext));
        leftPanel.add(addBtn);

        SeedData(list);
    }

    private void SeedData(List list) {
        list.removeAll();

        ArrayList<String> newList = serverContext.getPaymentsList();
        for (String s : newList) {
            list.add(s);
        }
    }

    private static class WindowClose extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }
}