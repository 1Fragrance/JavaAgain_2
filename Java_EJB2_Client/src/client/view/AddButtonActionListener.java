package client.view;

import client.ServerContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddButtonActionListener implements ActionListener {

    private final List _list;
    private final TextField _valueInput;
    private final TextField _codeInput;

    private final ServerContext _remoteObject;

    public AddButtonActionListener(List list, TextField valueInput, TextField codeInput, ServerContext remoteObject) {
        super();
        _list = list;
        _valueInput = valueInput;
        _codeInput = codeInput;
        _remoteObject = remoteObject;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String valueText = _valueInput.getText();
        String codeText = _codeInput.getText();
        if(!valueText.trim().equals("") && !codeText.trim().equals("")) {
            _remoteObject.insertPayment(valueText, codeText);
            _list.clear();

            ArrayList<String> newList = _remoteObject.getPaymentsList();
            for (String s : newList) {
                _list.add(s);
            }

            _valueInput.setText("");
            _codeInput.setText("");
        }
    }
}
