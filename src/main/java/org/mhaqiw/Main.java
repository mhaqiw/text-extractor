package org.mhaqiw;

import java.io.File;
import java.util.Map;
import org.mhaqiw.service.FileService;
import org.mhaqiw.service.ImageService;
import org.mhaqiw.service.TextService;

public class Main {
  public static void main(String[] args) {
    System.out.println("Start!");

    FileService fileService = new FileService();
    File[] listOfFiles = fileService.getFiles();

    ImageService imageService = new ImageService();
    String textAll = imageService.extractText(listOfFiles);

    TextService textService = new TextService();
    Map<String, String> map = textService.getFileDataMap(textAll);

    fileService.writeToFile(map);

    System.out.println("Finish!");
  }
}