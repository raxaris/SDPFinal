package com.company.myapp.adapter;

public class SqlFileSaver implements ISqlFileSaver {
    @Override
    public void saveToSqlFile(String fileName, String data) {
        System.out.println("Saved to SQL file: " + fileName);
    }

    @Override
    public String loadFromSqlFile(String fileName) {
        return "Data loaded from SQL file";
    }
}