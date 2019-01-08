package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class Zipper {

    String zip(String sourceFile) throws IOException {
        final File fileToZip = new File(sourceFile);
        final String zipFile = getZipName(sourceFile);
        try (final ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             final FileInputStream fis = new FileInputStream(fileToZip)) {
            
            final ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            final byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        }
        return zipFile;
    }

    private String getZipName(String sourceFile) {
        return sourceFile.substring(0, sourceFile.lastIndexOf(".")) + ".zip";
    }

}
