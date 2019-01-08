package com.example;

import java.io.IOException;

public class Runner {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Runner 'fileToZip'");
        } else {
            try {
                final String zipFile = new Zipper().zip(args[0]);
                System.out.println(String.format("Successfully zipped file '%s'", args[0]));
                new Unzipper().unzip(zipFile);
                System.out.println(String.format("Successfully upzipped file '%s'", zipFile));
            } catch (IOException e) {
                System.err.println(String.format("Could not zip file '%s'", args[0]));
            }
        }
    }

}
