package com.olvins.kit.dotnetdevkit;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GenerateCodeAction extends AnAction {

    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        Document document = editor.getDocument();

        // Create Swing input dialog.
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField namespaceField = new JTextField();
        JTextField classNameField = new JTextField();
        JTextField messageField = new JTextField();

        panel.add(new JLabel("Namespace:"));
        panel.add(namespaceField);
        panel.add(new JLabel("Class Name:"));
        panel.add(classNameField);
        panel.add(new JLabel("Message:"));
        panel.add(messageField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Generate Code", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String namespace = namespaceField.getText();
            String className = classNameField.getText();
            String message = messageField.getText();

            // You can add validation for inputs here if needed.

            // Generate the code.
            String code = generateCode(namespace, className, message);

            // Insert the code into the document.
            WriteCommandAction.runWriteCommandAction(project, () ->
                    document.insertString(editor.getCaretModel().getOffset(), code)
            );

            // Optionally, show a confirmation dialog.
            Messages.showMessageDialog(project, "Code generated successfully!", "Code Generated", Messages.getInformationIcon());
        }
    }

    private String generateCode(String namespace, String className, String message) {
        String template;
        try {
            // Load the template from a file, resource, etc.
            InputStream stream = getClass().getClassLoader().getResourceAsStream("templates/template_code_test.cs");
            template = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            // Handle errors (e.g., log, show a message to the user, etc.)
            return "// Failed to load the code template --> BUILD TEST.";
        }

        // Replace placeholders with actual values.
        template = template.replace("{NAMESPACE}", namespace);
        template = template.replace("{CLASS_NAME}", className);
        template = template.replace("{MESSAGE}", message);

        return template;
    }

}
