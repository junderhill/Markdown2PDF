package junderhill;

import java.io.*;
import java.util.HashMap;

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
        patterns.put(Paragraph.class, "");
        patterns.put(ListElement.class, "");
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

    }
}
