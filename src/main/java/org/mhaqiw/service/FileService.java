package org.mhaqiw.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class FileService {

  public void writeToFile(Map<String, String> fileData) {
    for (Map.Entry<String, String> entry : fileData.entrySet()) {
      write(entry.getValue(), entry.getKey());
    }
  }

  public File[] getFiles() {
    String rootPath = Objects.requireNonNull(
        Thread.currentThread().getContextClassLoader().getResource("")).getPath();
    File folder = new File(rootPath + "/images");
    return folder.listFiles();
  }

  private static void write(String coloredText, String filename) {
    try {
      String meta = "<meta charset=\"UTF-8\">\n";
      FileWriter writer = new FileWriter(filename);
      writer.write(meta + coloredText);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
