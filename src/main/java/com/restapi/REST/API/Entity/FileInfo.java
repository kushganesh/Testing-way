package com.restapi.REST.API.Entity;

import java.util.List;

public class FileInfo {
    private String  fileName;
    private String fileType;
//    private List<Integer> file;

    FileInfo(){}
    public FileInfo(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

//    public List<Integer> getFile() {
//        return file;
//    }
//
//    public void setFile(List<Integer> file) {
//        this.file = file;
//    }


    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
