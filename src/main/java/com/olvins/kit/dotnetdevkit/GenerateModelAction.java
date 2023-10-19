package com.olvins.kit.dotnetdevkit;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.components.JBList;
import com.olvins.kit.dotnetdevkit.types.ClassType;
import com.olvins.kit.dotnetdevkit.widgets.DynamicProperties;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class GenerateModelAction extends AnAction {

    public void actionPerformed(@NotNull AnActionEvent e) {

    }

    /*public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        Document document = editor.getDocument();

        // Create Swing input dialog.
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JCheckBox serializableCheckBox = new JCheckBox("Serializable:");
        JList classTypeList = new JBList(ClassType.values());
        classTypeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JTextField classNameField = new JTextField();
        JTextField extendField = new JTextField();
        DynamicProperties properties = new DynamicProperties();

        panel.add(new JCheckBox("Serializable:"));
        panel.add(classTypeList);
        panel.add(new JLabel("Class name:"));
        panel.add(classNameField);
        panel.add(new JLabel("Extendable:"));
        panel.add(extendField);
        panel.add(properties);


        int result = JOptionPane.showConfirmDialog(null, panel, "Generate Code", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // Generate the code.
            String code = generateCode(serializableCheckBox.isSelected(), ((ClassType) classTypeList.getSelectedValue()).getValue(), classNameField.getText(), extendField.getText(), properties);

            // Insert the code into the document.
            WriteCommandAction.runWriteCommandAction(project, () ->
                    document.insertString(editor.getCaretModel().getOffset(), code)
            );

            // Optionally, show a confirmation dialog.
            Messages.showMessageDialog(project, "Code generated successfully!", "Code Generated", Messages.getInformationIcon());
        }
    }

    private String generateCode(boolean serializable, String classType, String className, String extend, DynamicProperties dynamicProperties) {
        String template;
        try {
            // Load the template from a file, resource, etc.
            InputStream stream = getClass().getClassLoader().getResourceAsStream("templates/model_code.cs");
            template = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            // Handle errors (e.g., log, show a message to the user, etc.)
            return "// Failed to load the code template --> BUILD TEST.";
        }

        // Replace placeholders with actual values.
        template = template.replace("{SERIALIZABLE}", serializable ? "[Serializable]" : "");
        template = template.replace("{CLASS_TYPE}", classType);
        template = template.replace("{CLASS_NAME}", className);
        template = template.replace("{EXTENDABLE}", extend != null ? String.format(": %s", extend) : "");
        template = template.replace("{PROPERTIES}", generatePropertiesCode(dynamicProperties));

        return template;
    }

    private String generatePropertiesCode(DynamicProperties dynamicProperties) {
        String properties = "";
        DefaultTableModel model = dynamicProperties.model;
        for (int i = 0; i < model.getRowCount(); i++) {
            properties += String.format("public %s %s { get; set; } %n", model.getValueAt(i, 0), model.getValueAt(i, 1));
        }

        return properties;
    }*/
}
