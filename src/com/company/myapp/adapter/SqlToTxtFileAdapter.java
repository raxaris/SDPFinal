package com.company.myapp.adapter;


public class SqlToTxtFileAdapter implements ITxtFileSaver {
    private final ISqlFileSaver sqlFileSaver;

    public SqlToTxtFileAdapter(ISqlFileSaver sqlFileSaver) {
        this.sqlFileSaver = sqlFileSaver;
    }

    @Override
    public void saveToTxtFile(String fileName, String data) {
        sqlFileSaver.saveToSqlFile(fileName, data);
    }

    @Override
    public String loadFromTxtFile(String fileName) {
        return sqlFileSaver.loadFromSqlFile(fileName);
    }
}