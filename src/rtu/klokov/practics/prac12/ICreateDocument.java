package rtu.klokov.practics.prac12;

import java.io.IOException;

public interface ICreateDocument {
    IDocument CreateNew(String filename) throws IOException;
    IDocument CreateOpen(String filename);
}
