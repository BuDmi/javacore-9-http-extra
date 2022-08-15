package org.example;

import java.io.*;
import java.util.Arrays;

public class FileUtils {
    public static Boolean createNewFile(String projectFolderPath, String fileName) {
        File file = new File(projectFolderPath, fileName);

        try {
            if (file.exists()) {
                file.delete();
            }
            return file.createNewFile();
        } catch (IOException ex) {
            return false;
        }
    }

    public static void writeBytesToFile(String projectFolderPath, String file, byte[] data) throws IOException {
        try (FileOutputStream out = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(out)
        ) {
            bos.write(data, 0, data.length);
        } catch (IOException ex) {
            System.out.println(Arrays.toString(ex.getStackTrace()));
            throw new IOException(ex);
        }
    }

    public static String getFileNameFromUrl(String url) {
        int indexOfStartFileName = url.lastIndexOf("/") + 1;
        return url.substring(indexOfStartFileName);
    }
}
