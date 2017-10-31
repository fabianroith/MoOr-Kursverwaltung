/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moor_kursverwaltung;

import java.io.File;

/**
 *
 * @author User
 */
public class MyFile {
//    private static int id_counter = 0;
//    private int id;
    private File file;
    private String filename;

    public MyFile(File file) {
//        this.id = id_counter;
        this.file = file;
        this.filename = file.getName();
//        id_counter++;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return filename;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    
}
