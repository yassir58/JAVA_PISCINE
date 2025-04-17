package day02.ex02;

import java.io.File;

public class Shell {

    private String currentDirectory;
    private String[] cmdArguments;


    public Shell(String[] args) {
        parseArguments(args);
        this.cmdArguments = args;
    }
    public String getCurrentDirectory() {
        return currentDirectory;
    }

    public void checkCurrentDirectory() {
       // check if directory exist in file system
        File dir = new File(currentDirectory);

        if (!dir.exists()) {
            throw new FolderDoesNotExist("Directory does not exist: " + currentDirectory);
        }
        if (!dir.isDirectory()) {
            throw new InvalidArguments("Path is not a directory: " + currentDirectory);
        }

        System.out.println("Current directory is valid: " + currentDirectory);
    }

    public void startShell() {
        System.out.println("Starting shell...");
        System.out.println("Current directory: " + currentDirectory);
        System.out.println("Available commands: ls, cd <directory>");
        System.out.println("Type 'exit' to quit.");
        while (true) {
            System.out.print("-> ");
            try {
            String command = System.console().readLine();

            if (command.equals("exit")) {
                break;
            }
            try {
                parseCommend(command);
            } catch (InvalidCommand e) {
                System.out.println("Invalid command: " + e.getMessage());
            } catch (InvalidArguments e) {
                System.out.println("Invalid arguments: " + e.getMessage());
            } catch (FolderDoesNotExist e) {
                System.out.println("Folder does not exist: " + e.getMessage());
            }
            }catch (Exception e){
                System.out.println("Error reading command: " + e.getMessage());
            }
        }
    }

    public void cd(String newDirectory) {
        File dir = new File(newDirectory);
        if (dir.exists() && dir.isDirectory()) {
            currentDirectory = newDirectory;
            System.out.println("Changed directory to: " + currentDirectory);
        } else {
            throw new FolderDoesNotExist("Directory does not exist: " + newDirectory);
        }
    }
    public void parseCommend(String command) {
        if (command.equals("ls")) {
            ls();
        } else if (command.startsWith("cd")) {
            String[] parts = command.split(" ");
            if (parts.length != 2) {
                throw new InvalidArguments("Invalid cd command");
            }
            cd(parts[1]);
        } if (command.startsWith("mv")) {
            String[] parts = command.split(" ");
            if (parts.length != 3) {
                throw new InvalidArguments("Invalid mv command");
            }
            mv(parts[1], parts[2]);
        } else if (command.equals("exit")) {
            System.out.println("Exiting shell...");
        }
        else if (command.equals("help")) {
            System.out.println("Available commands: ls, cd <directory>, mv <source> <destination>");
        } else if (command.equals("clear")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
    public void ls() {
        File dir = new File(currentDirectory);
        File[] files  = dir.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return;
        }
        for (File file : files) {
                System.out.printf("%s  %d KB\n", file.getName(), file.length());
        }

    }
    public void parseArguments(String[] args) {
        if (args.length == 0) {
            throw new InvalidArguments("No arguments provided");
        }
        String[] arguments  =  args[0].split("=");
        if (arguments.length != 2) {
            throw new InvalidArguments("Invalid arguments format");
        }
        if (!arguments[0].equals("--current-folder")) {
            throw new InvalidCommand();
        }
        this.currentDirectory = arguments[1];
    }

    public void mv(String What, String Where){
        File file = new File(What) ;
        if (!file.exists()){
            throw new InvalidArguments("File does not exist: " + What);
        }
        if (file.isDirectory()){
            throw new InvalidArguments("File is a directory: " + What);
        }
        File file2 = new File(Where);
        if (!file2.exists()){
            throw new InvalidArguments("Destination does not exist: " + Where);
        }
        if (!file2.isDirectory()){
            throw new InvalidArguments("Destination is not a directory: " + Where);
        }
        File newFile = new File(file2, file.getName());
        if (file.renameTo(newFile)){
            System.out.println("File moved to: " + newFile.getAbsolutePath());
        } else {
            throw new InvalidArguments("File could not be moved: " + What);
        }
    }

}
