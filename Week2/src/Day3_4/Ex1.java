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
            return null;
            //System.exit(0);

        } 
        
        for (Path path : stream) {

            File file = path.toFile();

            if (file.isFile() && !file.isHidden()) {

                String fileExtension = file.getName().substring(file.getName().lastIndexOf(".") + 1); 
                int temp = 1;

                if (mapToCountFileExtensions.containsKey(fileExtension)) {

                    temp = mapToCountFileExtensions.get(fileExtension) + 1;

                }

                mapToCountFileExtensions.put(fileExtension, temp);

            } else if (file.isDirectory()) {

                countFilesExtension(file.getAbsolutePath(), mapToCountFileExtensions);

            }

        }

        return mapToCountFileExtensions;
    }

    public static void moveFiles(Path source, Path destination, HashMap<String, Integer> mapToMoveFiles) throws Exception {

        DirectoryStream<Path> srcStream = null;
        try {

            srcStream = Files.newDirectoryStream(source);

        } catch (NoSuchFileException ex) {

            System.err.println("Input should be a Folder!!!");
            return ;
            //System.exit(0);

        }
        for (Path srcPath : srcStream) {

            File srcFile = srcPath.toFile();
            if (srcFile.isFile() && !srcFile.isHidden()) {

                StringBuilder destbuilder = new StringBuilder(destination.toString());
                destbuilder.append("/");
                String destFilename = srcFile.getName().substring(0, srcFile.getName().lastIndexOf("."));
                String destFileExtension = srcFile.getName().substring(srcFile.getName().lastIndexOf(".") + 1);

                if (mapToMoveFiles.containsKey(destFilename)) {

                    destbuilder.append(destFilename);
                    destbuilder.append("-");
                    destbuilder.append(mapToMoveFiles.get(destFilename));
                    destbuilder.append(".");
                    destbuilder.append(destFileExtension);
                    mapToMoveFiles.put(destFilename, mapToMoveFiles.get(destFilename) + 1);

                } else {

                    //dest += file.getName();
                    destbuilder.append(srcFile.getName());
                    mapToMoveFiles.put(destFilename, 1);

                }
                
                Path target = Paths.get(destbuilder.toString());

                try {

                    Files.move(Paths.get(srcFile.getAbsolutePath()), target);

                } catch (FileAlreadyExistsException ex) {

                    mapToMoveFiles.put(destFilename, 2);
                    destbuilder.insert(destbuilder.indexOf("."), "-1");

                    Files.move(Paths.get(srcFile.getAbsolutePath()), Paths.get(destbuilder.toString()));

                }

            } else if (srcFile.isDirectory()) {

                moveFiles(Paths.get(srcFile.getAbsolutePath()), destination, mapToMoveFiles);

            }
        }

    }

    public static void main(String[] args) throws Exception {

        HashMap<String, Integer> mapToCountFileExtensions = new HashMap<>();
        HashMap<String, Integer> mapToMoveFiles = new HashMap<>();

        mapToCountFileExtensions = countFilesExtension("/Users/cb-sudarshan/Training/Week2/build/classes", mapToCountFileExtensions);
        if(mapToCountFileExtensions!=null){
            System.out.println(mapToCountFileExtensions);
        }
        Path dest = Paths.get("/Users/cb-sudarshan/friday/Tempo");
        Path source = Paths.get("/Users/cb-sudarshan/Training/Temporary");
        moveFiles(source, dest, mapToMoveFiles);

    }

}
