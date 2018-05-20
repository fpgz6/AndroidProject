package Entity;

/**
 * Created by MECHREVO on 2018/5/20.
 */

public class TeacherClass {
    private String course_name;
    private String course_date;
    private String course_Time;

    public TeacherClass(String course_name, String course_date, String course_Time) {
        this.course_name = course_name;
        this.course_date = course_date;
        this.course_Time = course_Time;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_date() {
        return course_date;
    }

    public void setCourse_date(String course_date) {
        this.course_date = course_date;
    }

    public String getCourse_Time() {
        return course_Time;
    }

    public void setCourse_Time(String course_Time) {
        this.course_Time = course_Time;
    }
}
