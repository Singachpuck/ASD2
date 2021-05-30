package ua.kpi.fict.acts.it03;

import java.io.IOException;

public interface ITextUnit {
    int findFirst(String file, String findingText) throws IOException;
    Integer[] findAll(String file, String findingText) throws IOException;
    void changeFirst(String file, String findingText, String changedText) throws IOException;
    void changeAll(String file, String findingText, String changedText) throws IOException;
}
