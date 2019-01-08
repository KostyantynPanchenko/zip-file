package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

class Unzipper {

    String unzip(String zipFile) throws IOException {
        final String fileName = getFileName(zipFile);
        final File unzippedFile = new File(fileName);
        try (final ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
             final FileOutputStream fos = new FileOutputStream(unzippedFile)) {
            
            final byte[] buffer = new byte[1024];
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
        return fileName;
    }

    private String getFileName(String zipFile) {
        return zipFile.substring(0, zipFile.lastIndexOf(".")) + ".txt";
    }

}
