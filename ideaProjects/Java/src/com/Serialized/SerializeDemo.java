package com.Serialized;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Re Ali";
        e.address = "Moats";
        e.SSN = 11223341;
        e.number = 10241;
        try {
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            System.out.println("Serialized data is saved in employee.ser");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
