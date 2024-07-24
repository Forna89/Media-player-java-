/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcMediaPlayer;

import java.io.File;
import java.util.logging.Logger;

/**
 *
 * @author DENOR Spencer
 */
public class FileSelected {
   private int id;
   private File f;
   private String nameFile;
   private String filePath;

    public FileSelected() {
    }

    public FileSelected(int id, File f, String nameFile, String filePath) {
        this.id = id;
        this.f = f;
        this.nameFile = nameFile;
        this.filePath = filePath;
    }
    private static final Logger LOG = Logger.getLogger(FileSelected.class.getName());

    public int getId() {
        return id;
    }

    public File getF() {
        return f;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getFilePath() {
        return filePath;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setF(File f) {
        this.f = f;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    
    
}
