package com.olvins.kit.dotnetdevkit.widgets;

import com.intellij.ui.components.JBList;
import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicProperties extends JPanel {

    private JTable table;
    public DefaultTableModel model;
    private JButton addButton;
    private JList keyField;
    private JTextField valueField;

    /*public DynamicProperties() {
        // Model and table setup
        model = new DefaultTableModel(new Object[]{"Property", "Value"}, 0);
        table = new JBTable(model);

        // Input fields and button
        keyField = new JBList<>(VariableI.values());
        valueField = new JTextField();
        addButton = new JButton("Add Property");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = ((VariableI) keyField.getSelectedValue()).getValue();
                String value = valueField.getText();
                if (key != null && !key.trim().isEmpty() && value != null && !value.trim().isEmpty()) {
                    model.addRow(new Object[]{key, value});
                    keyField.setSelectedIndex(-1);
                    valueField.setText("");
                }
            }
        });

        // Layout
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 3));
        inputPanel.add(keyField);
        inputPanel.add(valueField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.SOUTH);
    }*/
}
