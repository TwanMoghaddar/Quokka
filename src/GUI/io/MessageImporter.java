package GUI.io;

import Design.Logger;
import GUI.Main.Message;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageImporter {

    public static List<Message> importMessages() throws Exception {

        Scanner scanner = new Scanner(new File("results.txt"));
        List<Message> results = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] parts = line.split(";");

            parts[2] = parts[2].replaceAll("±", "\n");

            results.add(new Message(parts[0], parts[2]));
        }

        Logger.confirm("Imported " + results.size() + " results");
        return results;
    }
}
