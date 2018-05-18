package util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Entity.Reservation;
import Entity.Student;
import Entity.Teacher;


/**
 * Created by 42519 on 2018/5/18.
 */

public class JsonTool {

    public static ArrayList<Reservation> getAllReservation(String key, String jsonString) {
        ArrayList<Reservation> list = new ArrayList<Reservation>();
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
            JSONArray Persons = jsonObject.getJSONArray(key);
            for (int i = 0; i < Persons.length(); i++) {
               Reservation reservation=new Reservation();
                JSONObject jsonObject2 = Persons.getJSONObject(i);
                reservation.setId(jsonObject2.getString("id"));
                reservation.setStudent_id(jsonObject2.getString("student_id"));
                reservation.setTeacher_id(jsonObject2.getString("teacher_id"));
                reservation.setDate(jsonObject2.getString("date"));
                reservation.setPeriod(jsonObject2.getInt("period"));
                reservation.setContent(jsonObject2.getString("content"));
                reservation.setPrice(jsonObject2.getInt("price"));
                reservation.setComment(jsonObject2.getString("comment"));
                reservation.setMark(jsonObject2.getInt("mark"));
                reservation.setStatus(jsonObject2.getInt("status"));
                list.add(reservation);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }
    public static Reservation getReservation(String key, String jsonString) {
        Reservation reservation=null;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
            JSONArray Persons = jsonObject.getJSONArray(key);
            for (int i = 0; i < Persons.length(); i++) {
                reservation=new Reservation();
                JSONObject jsonObject2 = Persons.getJSONObject(i);
                reservation.setId(jsonObject2.getString("id"));
                reservation.setStudent_id(jsonObject2.getString("student_id"));
                reservation.setTeacher_id(jsonObject2.getString("teacher_id"));
                reservation.setDate(jsonObject2.getString("date"));
                reservation.setPeriod(jsonObject2.getInt("period"));
                reservation.setContent(jsonObject2.getString("content"));
                reservation.setPrice(jsonObject2.getInt("price"));
                reservation.setComment(jsonObject2.getString("comment"));
                reservation.setMark(jsonObject2.getInt("mark"));
                reservation.setStatus(jsonObject2.getInt("status"));
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return reservation ;
    }
    public static ArrayList<Teacher> getAllTeachers(String key, String jsonString) {
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
            JSONArray Persons = jsonObject.getJSONArray(key);
            for (int i = 0; i < Persons.length(); i++) {
                Teacher teacher=new Teacher();
                JSONObject jsonObject2 = Persons.getJSONObject(i);
                teacher=new Teacher();
                teacher.setId(jsonObject2.getString("id"));
                teacher.setPassword(jsonObject2.getString("password"));
                teacher.setName(jsonObject2.getString("name"));
                teacher.setGender(jsonObject2.getInt("gender"));
                teacher.setAge(jsonObject2.getInt("age"));
                teacher.setHour_price(jsonObject2.getInt("hour_price"));
                teacher.setAlipay(jsonObject2.getString("alipay"));
                teacher.setRegion(jsonObject2.getString("region"));
                teacher.setSubject(jsonObject2.getString("subject"));
                list.add(teacher);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }
    public static Teacher getTeacher(String key, String jsonString) {
        Teacher teacher=null;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
            JSONArray Persons = jsonObject.getJSONArray(key);
            for (int i = 0; i < Persons.length(); i++) {
                teacher=new Teacher();
                JSONObject jsonObject2 = Persons.getJSONObject(i);
                teacher=new Teacher();
                teacher.setId(jsonObject2.getString("id"));
                teacher.setPassword(jsonObject2.getString("password"));
                teacher.setName(jsonObject2.getString("name"));
                teacher.setGender(jsonObject2.getInt("gender"));
                teacher.setAge(jsonObject2.getInt("age"));
                teacher.setHour_price(jsonObject2.getInt("hour_price"));
                teacher.setAlipay(jsonObject2.getString("alipay"));
                teacher.setRegion(jsonObject2.getString("region"));
                teacher.setSubject(jsonObject2.getString("subject"));
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return teacher;
    }
    public static Student getStudent(String key, String jsonString) {
        Student student=null;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
            JSONArray Persons = jsonObject.getJSONArray(key);
            for (int i = 0; i < Persons.length(); i++) {
                student=new Student();
                JSONObject jsonObject2 = Persons.getJSONObject(i);
                student.setId(jsonObject2.getString("id"));
                student.setPassword(jsonObject2.getString("password"));
                student.setName(jsonObject2.getString("name"));
                student.setGender(jsonObject2.getInt("gender"));
                student.setAge(jsonObject2.getInt("age"));
                student.setGrade(jsonObject2.getString("grade"));
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return student;
    }
    public static ArrayList<Student> getAllStudents(String key, String jsonString) {
        ArrayList<Student> list=new ArrayList<>();
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonString);
            JSONArray Persons = jsonObject.getJSONArray(key);
            for (int i = 0; i < Persons.length(); i++) {
                Student student=new Student();
                JSONObject jsonObject2 = Persons.getJSONObject(i);
                student.setId(jsonObject2.getString("id"));
                student.setPassword(jsonObject2.getString("password"));
                student.setName(jsonObject2.getString("name"));
                student.setGender(jsonObject2.getInt("gender"));
                student.setAge(jsonObject2.getInt("age"));
                student.setGrade(jsonObject2.getString("grade"));
                list.add(student);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }
}
