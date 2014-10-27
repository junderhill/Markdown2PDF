package junderhill;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jason.Underhill on 16/10/2014.
 */
public class MarkdownParser {
  private String filename;
  private Document document;
  private HashMap patterns;

  public MarkdownParser(String filename)
  {
    this.filename = filename;
    patterns = new HashMap();
    PopulatePatterns();
  }

  private void PopulatePatterns() {
    patterns.put(Heading.class, "^#{1,5}.*#?");
    patterns.put(Paragraph.class, "^a$"); //TODO: Update this regex as it is written not to match for debugging
    patterns.put(ListElement.class, "^[\\s\\t]*\\*{1}[\\s\\t]+.*");
  }

  public IDocument ParseDocument() throws IOException {
    document = new Document();

    FileReader file = new FileReader(filename);
    BufferedReader buffer = new BufferedReader(file);

    String line;
    while((line = buffer.readLine()) != null)
    {
      ParseLine(line);
    }

    return document;
  }

  private void ParseLine(String line) {
    for(Object key : patterns.keySet())
    {
      String pattern = (String)patterns.get(key);
      Pattern p = Pattern.compile((String)pattern);
      Matcher matcher = p.matcher(line);
      if(matcher.find())
      {
        HandleMatch(matcher, line, key);
        break;
      }
    }
    Pattern pattern = Pattern.compile("");
    Matcher matcher = pattern.matcher(filename);
  }

  private void HandleMatch(Matcher matcher, String line, Object key) {
    if(key == Heading.class)
    {
      CreateHeading(line);
    }
  }

  private void CreateHeading(String line) {
    Heading heading = new Heading();
    heading.setValue(line.replace("#", ""));
    document.elements.add(heading);
  }
}
