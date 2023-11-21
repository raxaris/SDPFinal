package com.company.myapp.adapter;

public interface ISqlFileSaver {
    void saveToSqlFile(String fileName, String data);
    String loadFromSqlFile(String fileName);
}
