/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Json;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import org.json.*;


/**
 *
 * @author cb-sudarshan
 */
public class JSONMainEx1 {

    public static void main(String[] args) throws JSONException {

        String JSONtext = "";
        Student student = new Student();
        Teacher teacher = new Teacher();
        Mark[] studentMarks = new Mark[6];//
        String[] handlingClassOfTeacher = null;
        
        try {
            
            JSONtext = new String(Files.readAllBytes(Paths.get("/Users/cb-sudarshan/Training/Downloads/Files/students-teachers.json"))
                    , StandardCharsets.UTF_8);
            
        } catch (FileNotFoundException e) {
            
            System.err.println(e);
            System.exit(0);
            
        } catch (IOException e) {
            
            System.err.println(e);
            System.exit(0);
            
        }
        
        JSONObject jsonObject = new JSONObject(JSONtext);
        
        JSONObject jsonStudentObj = jsonObject.getJSONObject("Student");
        JSONObject jsonTeacherObj = jsonObject.getJSONObject("Teacher");
        
        JSONArray studentmarksJsonArray = jsonStudentObj.getJSONArray("Marks");
        JSONArray teacherHandlingClassJsonArray = jsonTeacherObj.getJSONArray("Classes Taking Care Of");
        handlingClassOfTeacher = new String[teacherHandlingClassJsonArray.length()];
        for(int i = 0; i < teacherHandlingClassJsonArray.length(); i++){
            handlingClassOfTeacher[i] = (String) (teacherHandlingClassJsonArray.get(i));
        }

        for (int i = 0; i < studentmarksJsonArray.length(); i++) {

            JSONObject tempMarkObj = studentmarksJsonArray.getJSONObject(i);
            Integer tempmark = tempMarkObj.optInt("Mark");
            String tempsubject = tempMarkObj.optString("Subject").replaceAll(" ", "").toUpperCase();
            if (tempmark != null) {
                studentMarks[i] = new Mark(tempsubject, tempmark);
            }

        }
        
        student.setMarks(studentMarks).setName(jsonStudentObj.getString("Name"))
                .setId(jsonStudentObj.getString("ID")).setDateOfJoining(jsonStudentObj.getString("Date Of Joining"))
                .setStandard(jsonStudentObj.getString("Std"));
        
        teacher.setDate(jsonTeacherObj.getString("Date Of Joining")).setId(jsonTeacherObj.getString("ID"))
                .setName(jsonTeacherObj.getString("Name")).setSalary(jsonTeacherObj.getLong("Salary"))
                .setHandlingClasses(handlingClassOfTeacher);
        
        System.out.println(student);
        System.out.println(teacher);
    }

}
