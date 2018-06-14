/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template path, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3_4;

import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 *
 * @author cb-sudarshan
 */
public class Ex1 {

    public static HashMap countFilesExtension(String directoryName, HashMap<String, Integer> mapToCountFileExtensions) throws Exception {

        Path dir = Paths.get(directoryName);

        DirectoryStream<Path> stream = null;

        try {

            stream = Files.newDirectoryStream(dir);

        } catch (NoSuchFileException ex) {

            System.err.println("Input should be a Folder!!!");

        } catch (IOException | DirectoryIteratorException x) {

            System.err.println(x);
            throw x;

        }
        for (Path path : stream) {

            File file = path.toFile();

            if (file.isFile() && !file.isHidden()) {

                String fileExtension = file.getName().substring(file.getName().lastIndexOf(".") + 1); //this wont work for 1.asdf.txt
                int temp = 1;

                if (mapToCountFileExtensions.containsKey(fileExtension)) {

                    temp = mapToCountFileExtensions.get(fileExtension) + 1;

                }

                mapToCountFileExtensions.put(fileExtension, temp++);

            } else if (file.isDirectory()) {

                countFilesExtension(file.getAbsolutePath(), mapToCountFileExtensions);

            }

        }

        return mapToCountFileExtensions;
    }

    public static void moveFiles(Path source, Path destination, HashMap<String, Integer> mapToMoveFiles) throws Exception {

        DirectoryStream<Path> stream = null;
        try {

            stream = Files.newDirectoryStream(source);

        } catch (NoSuchFileException ex) {

            System.err.println("Input should be a Folder!!!");

        }
        for (Path path : stream) {

            File file = path.toFile();
            if (file.isFile() && !file.isHidden()) {

                String dest = destination.toString();
                StringBuilder destbuilder = new StringBuilder(dest);
                destbuilder.append("/");
                String filename = file.getName().substring(0, file.getName().lastIndexOf("."));
                String fileExtension = file.getName().substring(file.getName().lastIndexOf(".") + 1);

                if (mapToMoveFiles.containsKey(filename)) {

                    //dest += filename + "-" + mapToMoveFiles.get(filename) + "." + fileExtension;
                    //destbuilder.append(filename + "-" + mapToMoveFiles.get(filename) + "." + fileExtension);
                    destbuilder.append(filename);
                    destbuilder.append("-");
                    destbuilder.append(mapToMoveFiles.get(filename));
                    destbuilder.append(".");
                    destbuilder.append(fileExtension);
                    mapToMoveFiles.put(filename, mapToMoveFiles.get(filename) + 1);

                } else {

                    //dest += file.getName();
                    destbuilder.append(file.getName());
                    mapToMoveFiles.put(filename, 1);

                }
                
                dest = destbuilder.toString();
                Path target = Paths.get(dest);

                try {

                    Files.move(Paths.get(file.getAbsolutePath()), target);

                } catch (FileAlreadyExistsException ex) {

                    mapToMoveFiles.put(filename, 2);
                    //dest += filename + "-1." + fileExtension;
                    destbuilder.append(filename);
                    destbuilder.append("-1.");
                    destbuilder.append(fileExtension);
                    dest = destbuilder.toString();
                    Files.move(Paths.get(file.getAbsolutePath()), Paths.get(dest));

                }

            } else if (file.isDirectory()) {

                moveFiles(Paths.get(file.getAbsolutePath()), destination, mapToMoveFiles);

            }
        }

    }

    public static void main(String[] args) throws Exception {

        HashMap<String, Integer> mapToCountFileExtensions = new HashMap<>();
        HashMap<String, Integer> mapToMoveFiles = new HashMap<>();

        mapToCountFileExtensions = countFilesExtension("/Users/cb-sudarshan/Training/Week2/build/classes", mapToCountFileExtensions);
        System.out.println(mapToCountFileExtensions);

        Path dest = Paths.get("/Users/cb-sudarshan/friday/Tempo");
        Path source = Paths.get("/Users/cb-sudarshan/Training/Temporary");
        moveFiles(source, dest, mapToMoveFiles);

    }

}
