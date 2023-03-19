package org.mhaqiw.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {

  public Map<String, String> getFileDataMap(String textAll) {
    StringBuilder english = new StringBuilder();
    StringBuilder chinese = new StringBuilder();

    for (int i = 0; i < textAll.length(); i++) {
      int codepoint = textAll.codePointAt(i);
      Character.UnicodeScript script = Character.UnicodeScript.of(codepoint);
      if (script == Character.UnicodeScript.HAN) {
        chinese.append(textAll.charAt(i));
        continue;
      }
      english.append(textAll.charAt(i));
    }

    Pattern regex = Pattern.compile("\\b\\w*[oO]\\w*\\b");
    Matcher matcher = regex.matcher(english);

    // Apply blue font color to the matching words
    String englishColored = matcher.replaceAll("<span style=\"color: blue; \">$0</span>");

    Map<String, String> map = new HashMap<>();
    map.put("english.html", englishColored);
    map.put("chinese.html", chinese.toString());
    return map;
  }

}
