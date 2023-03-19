package org.mhaqiw.service;

import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class ImageService {

  private ITesseract tesseract;

  public ImageService() {
    this.tesseract = new Tesseract();
    this.tesseract.setLanguage("eng+chi_tra");
    this.tesseract.setDatapath("/opt/homebrew/share/tessdata/");
  }

  public String extractText(File[] files) {
    StringBuilder sb = new StringBuilder();
    for (File file : files) {
      try {
        String text = tesseract.doOCR(file);
        sb.append(text);
        sb.append(" ");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return sb.toString();
  }

}
