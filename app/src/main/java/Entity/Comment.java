package Entity;

/**
 * Created by MECHREVO on 2018/5/19.
 */

public class Comment {
    private String student_id;
    private String comment;
    private int mark;
    private String student_name;

    public Comment(String student_id, String comment, int mark, String student_name) {
        this.student_id = student_id;
        this.comment = comment;
        this.mark = mark;
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
