package com.example.rgzlinux;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;

public class FileWork {
    private ArrayList<String> dataList=new ArrayList<>();


   public void writingFile(File file,String outFile) throws IOException {

        FileWriter fw = new FileWriter(file, false);
        fw.write(outFile);
        fw.close();
    }

    public void readFile(File file, TextArea textField) throws IOException {
        int i = 0;
        String line;
        String filling="";

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
            textField.appendText(line+"\n");
           filling+=line+System.lineSeparator();
        }

        br.close();
        fr.close();

    }

}