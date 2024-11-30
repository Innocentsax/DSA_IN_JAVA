package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> contain);
}