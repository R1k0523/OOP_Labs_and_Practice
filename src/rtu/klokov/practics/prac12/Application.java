package rtu.klokov.practics.prac12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class Application extends JFrame {

    private final String[] fileFormats = {"Блокнот","Редактор фото","Аудиоредактор"};

    private ICreateDocument createDocument;
    private IDocument document;
    private JMenuBar jMenuBar=new JMenuBar();
    private JMenu jMenu=new JMenu("File");
    private JMenuItem newItem=new JMenuItem("Создать");
    private JMenuItem openItem=new JMenuItem("Открыть");
    private JMenuItem saveItem=new JMenuItem("Сохранить");
    private JMenuItem exitItem=new JMenuItem("Закрыть");

    Application(){
        setSize(800,600);
        setLocation((1920-1280)/2,(1080-720)/2);
        setLayout(new GridBagLayout());

        jMenu.add(newItem);
        jMenu.add(openItem);
        jMenu.add(saveItem);
        jMenu.add(exitItem);
        jMenuBar.add(jMenu);

        GridBagConstraints textFieldsConstraint= new GridBagConstraints();
        textFieldsConstraint.fill=GridBagConstraints.HORIZONTAL;
        textFieldsConstraint.anchor=GridBagConstraints.NORTHWEST;
        textFieldsConstraint.weighty=0.05;
        textFieldsConstraint.weightx=1;
        textFieldsConstraint.gridx=0;
        textFieldsConstraint.gridy=0;

        newButton();
        openButton();
        saveButton();
        exitButton();

        add(jMenuBar,textFieldsConstraint);
        setVisible(true);
    }

    private void newButton() {
        newItem.addActionListener(e -> {
            closePrevious();
            choiseDialog();
            if(createDocument!=null) {
                String name = JOptionPane.showInputDialog(null, "Введите название файла");
                try {
                    if(name!=null)  {
                        document = createDocument.CreateNew(name);
                        document.open(Application.this);
                    }
                } catch (FileAlreadyExistsException E) {
                    JOptionPane.showMessageDialog(null, "Файл " + name + ".txt уже создан");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    private void openButton() {
        openItem.addActionListener(e -> {
            closePrevious();
            choiseDialog();
            if(createDocument!=null){
                String name = JOptionPane.showInputDialog(
                        null,
                        "Введите название файла");
                if(name!=null) {
                    document = createDocument.CreateOpen(name);
                    try {
                        document.open(Application.this);
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(null, "Файл не существует");
                    }
                }
            }
        });
    }

    private void saveButton() {
        saveItem.addActionListener(e -> {
            if(document!=null)
                try {
                    document.save(Application.this);
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(null,"ОШИБКА");
                }
        });
    }
    private void exitButton() {
        exitItem.addActionListener(e -> {
            if(document!=null)
                try {
                    document.exit(Application.this);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            document=null;
        });
    }

    private void closePrevious() {
        if (document != null) {
            try {
                document.exit(Application.this);
                createDocument=null;
                document = null;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void choiseDialog() {
        String result = (String) JOptionPane.showInputDialog(
                null,
                "Выберите тип файла:",
                "Выбор файла",
                JOptionPane.QUESTION_MESSAGE, null, fileFormats, fileFormats[0]);

        if (result != null) {
            if ("Блокнот".equals(result)) {
                createDocument = new TextCreateDocument();
            } else
                JOptionPane.showMessageDialog(null, "Ожидайте обновлений");
        }
    }

}
