package ru.garmayev;

import ru.garmayev.application.App;

public class Main {
    private static App application = new App();
    public static void parseArgs(String[] args)
    {
        for ( int i = 0; i < args.length; i += 2 ) {
            if ( args[i].equals("-f") ) {
                application.fileMode = true;
                application.fileName = args[i+1];
            }
        }
    }

    public static void main(String[] args) {
//        application;
        parseArgs(args);
        application.run();
    }
}
