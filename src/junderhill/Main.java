package junderhill;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Main {

    public static void main(String[] args) {
	    if(ValidateArguments(args))
        {

        }
    }

    private static boolean ValidateArguments(String[] args) {
        if(args.length != 1)
        {
            System.out.println("Only 1 argument can be supplied. It must be a *.md filename");
            return false;
        }

        //TODO: Check is filename

        //TODO: Check file exists.

        return true;
    }

    private static boolean DoesFileExist(String filename)
    {
        throw new NotImplementedException();
    }

}
