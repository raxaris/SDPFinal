package com.company.myapp.adapter;

public interface ITxtFileSaver {
    void saveToTxtFile(String fileName, String data);
    String loadFromTxtFile(String fileName);
}