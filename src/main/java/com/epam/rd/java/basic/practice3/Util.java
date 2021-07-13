package com.epam.rd.java.basic.practice3;

        import jdk.internal.logger.BootstrapLogger;

        import java.io.File;
        import java.io.IOException;
        import java.util.Scanner;

public class Util {
    private static BootstrapLogger logger;

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            logger.log(ex);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        System.out.println(input);
    }
}
