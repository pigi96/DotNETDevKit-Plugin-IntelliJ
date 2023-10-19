package com.olvins.kit.dotnetdevkit.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class CodeBlocksAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        Document document = editor.getDocument();

        JPanel jPanel = new JPanel(new GridLayout(5, 2));
        jPanel.add(new CodeBlocksAction_gui().getPanel());

        JFrame frame = new JFrame("Frame 2");
        frame.setContentPane(jPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
