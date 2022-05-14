package com.example.rgzlinux;

public class DataCompression {

    public String Compression(String code) {
        String compressionLine = "";

        for( int i = 0; i < code.length(); i++){
            int count = 1;

            while( i < code.length() - 1 && code.charAt(i) == code.charAt(i + 1) ){
                count++;
                i++;
            }

            compressionLine+=String.valueOf(count) + String.valueOf(code.charAt(i));
        }

        return compressionLine;
    }

}
