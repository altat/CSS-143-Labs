//@author Tanvir Tatla
import java.io.File;
import java.util.Stack;

public class FileSearch {

    public static void main(String[] args) {
        File path = new File("C:\\");
        String target = "hw3.zip";
        System.out.println(recursiveSearch(path, target));
    }

    /*
        Add the given directory to a stack
        while(the stack contains a directory)  {
            Get a directory
            If a file, check if it matches with the target
            If a directory,
            for(each file and directory in the directory) {
                if a file, check for a match and return if found
                if a directory, push this to the stack
            }
        }
        return not found
     */

    public static String searchFiles(File path, String target) {
        Stack directories = new Stack();

        directories.push(path);

        while (!directories.isEmpty()) {
            File dir = (File) directories.pop();

            if (dir == null) {
                continue;
            }

            if (dir.isFile()) {
                if (dir.getName().equals(target)) {
                    return "File found at: " + dir.toString();
                }
            } else {
                File[] list = dir.listFiles();

                if (list == null) {
                    continue;
                }

                for (int i = 0; i < list.length; i++) {
                    if (list[i].isFile()) {
                        if (list[i].getName().equals(target)) {
                            return "File found at: " + list[i].toString();
                        }
                    } else {
                        directories.push(list[i]);
                    }
                }
            }
        }

        return "File Not Found.";
    }

    /*
        check if path is actually a dir, abort if not
        loop over all files & dirs in the current directory
            if a directory and not empty, repeat these steps
            if found in the directory, return found
            if a file, check for a match and return if found
    */
    public static String recursiveSearch(File path, String target) {
        Stack directories = new Stack();

        directories.push(path);

        while (!directories.isEmpty()) {
            File dir = (File) directories.pop();

            if (dir == null) continue;

            File[] list = dir.listFiles();

            if (list == null) continue;

            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory() && list[i].listFiles().length > 0) {
                    try {
                        return recursiveSearch(list[i], target);
                    } catch (NullPointerException e) {
                        System.out.println("Access denied at: " + list[i]);
                    }
                } else {
                    if (list[i].getName().equals(target))
                        return "File found at: " + list[i].toString();
                }
            }
        }
        return "File not found.";
    }

}
