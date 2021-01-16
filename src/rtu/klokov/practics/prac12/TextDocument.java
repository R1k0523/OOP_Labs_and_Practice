package rtu.klokov.practics.prac12;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class TextDocument implements IDocument {
    private File file;
    public TextDocument(String name){
        file=new File("src/rtu/klokov/practics/prac12/resources/" + name+".txt");
    }

    public void create() throws IOException {
        if(file.exists()) throw new FileAlreadyExistsException(file.getName());
        file.createNewFile();
    }

    public void open(JFrame frame) throws IOException {
        int c;
        FileReader fileReader=new FileReader(file);
        GridBagConstraints textFieldsConstraint= new GridBagConstraints();
        textFieldsConstraint.fill=GridBagConstraints.BOTH;
        textFieldsConstraint.weightx=1.0f;
        textFieldsConstraint.weighty=0.95;
        textFieldsConstraint.anchor=GridBagConstraints.SOUTHWEST;
        textFieldsConstraint.gridx=0;
        textFieldsConstraint.gridy=1;

        JTextArea textArea=new JTextArea("");
        while((c= fileReader.read())!=-1){
            textArea.setText(textArea.getText()+(char)c);
        }
        JScrollPane jScrollPane=new JScrollPane(textArea);
        frame.add(jScrollPane,textFieldsConstraint);

        frame.setVisible(true);
        fileReader.close();
        
    }

    public void save(JFrame frame) throws IOException {
        PrintWriter fileWriter=new PrintWriter(file);
        JRootPane jRootPane= (JRootPane) frame.getComponent(0);
        JLayeredPane jLayeredPane= (JLayeredPane) jRootPane.getComponent(1);
        JPanel jPanel= (JPanel) jLayeredPane.getComponent(0);
        JScrollPane jScrollPane= (JScrollPane) jPanel.getComponent(1);
        JViewport jViewport= (JViewport) jScrollPane.getComponent(0);
        JTextArea jTextArea= (JTextArea) jViewport.getComponent(0);
        fileWriter.write(jTextArea.getText());
        fileWriter.close();
    }

    public void exit(JFrame frame) throws IOException {
        save(frame);
        JRootPane jRootPane= (JRootPane) frame.getComponent(0);
        JLayeredPane jLayeredPane= (JLayeredPane) jRootPane.getComponent(1);
        JPanel jPanel= (JPanel) jLayeredPane.getComponent(0);
        jPanel.remove(1);
        frame.setVisible(false);
        frame.setVisible(true);
    }

}
