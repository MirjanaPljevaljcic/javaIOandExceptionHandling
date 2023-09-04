package userValidator;

import java.io.*;

public class UserDataValidator {

    public static void main(String[] args) {
        String inputFilePath = "src/data/user_data.txt";
        String validOutputFilePath = "src/data/valid_data.txt";
        String errorOutputFilePath = "src/data/error_data.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter validWriter = new BufferedWriter(new FileWriter(validOutputFilePath));
            BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorOutputFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");

                    if (parts.length != 3) {
                        throw new Exception("Missing Data");
                    }

                    String name = parts[0].trim();
                    String email = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());

                    if (age <= 0) {
                        throw new Exception("Invalid Age");
                    }

                    validWriter.write(line + "\n");

                } catch (Exception e) {
                    errorWriter.write(line + " - Error: " + e.getMessage() + "\n");
                }
            }

            reader.close();
            validWriter.close();
            errorWriter.close();

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}

