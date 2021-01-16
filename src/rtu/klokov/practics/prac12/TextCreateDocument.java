package rtu.klokov.practics.prac12;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class TextCreateDocument implements ICreateDocument {
    public IDocument CreateNew(String filename) throws IOException {
        TextDocument textDocument=new TextDocument(filename);
        textDocument.create();
        return textDocument;
    }

    public IDocument CreateOpen(String filename) {
        TextDocument textDocument=new TextDocument(filename);
        return textDocument;
    }
}
