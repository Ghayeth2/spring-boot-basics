package com.patika_course.tutorials.core.io;

import lombok.extern.log4j.Log4j2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;
@Log4j2
public class IOStream {
    private String db = "D:\\Java\\Intellij tests\\backend_patika\\db.txt";
    public void save(Object object){
        try {
            FileOutputStream dbLocation = new FileOutputStream(db);
            ObjectOutputStream objectOut = new ObjectOutputStream(dbLocation);
            objectOut.writeObject(object);
            objectOut.close();
            log.info("Saved to file successfully");

        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
