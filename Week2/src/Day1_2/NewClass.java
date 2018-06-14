/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1_2;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;



/**
 *
 * @author cb-sudarshan
 */
public class NewClass {
    
    public static void main(String[] args)throws Exception{
//        Path source = Paths.get("/Users/cb-sudarshan/Training/Temporary");
//        File f = source.toFile();
//        File[] d = f.listFiles((dir1, name) -> name.startsWith("Add"));
//        //System.out.println(f.listFiles((dir1, name) -> name.startsWith("Add")));
//        System.out.println(d.length);
//        
//        Path dq = Paths.get("/home/joe/joe/foo");
//        System.out.println(dq.normalize().toString());
//        
//        Path temp = Paths.get("../../friday/Friday.java");
//        
//        //curr dir -> week 2
//        System.out.println(temp.toAbsolutePath());
//        System.out.println(temp.toRealPath().toAbsolutePath());
        

        String s = "D:/test/textfile.txt.html!!?";

        
//        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/Users/cb-sudarshan/Training/Week2/build/classes"));
//        for(Path p : stream){
//            System.out.println(p.toString());
//        }
//        Path dir = Paths.get("/Users/cb-sudarshan/Training/Temporary/Redundant");
//        DirectoryStream<Path> stream = Files.newDirectoryStream(dir);   
//        for(Path p :stream){
//            System.out.println(p.toString());
//        }
        
//        File file =
//      new File("/Users/cb-sudarshan/file.txt");
//    Scanner sc = new Scanner(file).useDelimiter(" ");
// 
//    while (sc.hasNext()){
//        String l = sc.next();
//        System.out.println(l.replaceAll("[^a-zA-Z0-9]", " "));
//    }
    
    //String csv = String.join(",", ids)
     Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        String ss = sc.nextLine();
        String g = sc.nextLine();
        System.out.println(a);
        System.out.println(ss);
        System.out.println(g);
    

        
    }
    
}
