package Entity;

/**
 * Created by MECHREVO on 2018/5/14.
 */

public class MyCourse {
        private String teacher_id;
        private String teacher;
        private String time;
        private String type;
        public MyCourse(String teacher_id, String teacher_name, String time, String subject) {
            this.teacher_id = teacher_id;
            this.teacher = teacher_name;
            this.time = time;
            this.type = subject;
        }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }
}

