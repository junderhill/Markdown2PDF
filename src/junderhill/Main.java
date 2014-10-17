package junderhill;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
	    if(ValidateArguments(args))
        {
            MarkdownParser parser = new MarkdownParser(args[0]);
            IDocument document = parser.ParseDocument();
        }
    }

    private static boolean ValidateArguments(String[] args) {
        if(args.length != 1)
        {
            System.out.println("Only 1 argument can be supplied. It must be a *.md filename");
            return false;
        }
        if (!IsValidFilenameFormat(args[0])) {
            System.out.println("File format is invalid");
            return false;
        }

        if(!DoesFileExist(args[0]))
        {
            System.out.println("File does not exist");
            return false;
        }
        return true;
    }

    private static boolean IsValidFilenameFormat(String filename) {
        return true;
        //TODO: Write regex for filename matching
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(filename);
        if(matcher.find())
        {
            return true;
        }
        return false;
    }

    private static boolean DoesFileExist(String filename)
    {
        File file = new File(filename);
        if(file.exists() && !file.isDirectory())
        {
            return true;
        }
        return false;
    }

}
