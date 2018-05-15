package Entity;

/**
 * Created by JAY on 2018/5/2.
 */

public class CourseView {
    private int pic_src;
    private String name;
    private double hour_price;
    private int time;
    private String subject;
    private int comment;

    public CourseView(int pic_src, String name, double hour_price, int time, String subject, int comment) {
        this.pic_src = pic_src;
        this.name = name;
        this.hour_price = hour_price;
        this.time = time;
        this.subject = subject;
        this.comment = comment;
    }

    public int getPic_src() {
        return pic_src;
    }

    public String getName() {
        return name;
    }

    public double getHour_price() {
        return hour_price;
    }

    public int getTime() {
        return time;
    }

    public String getSubject() {
        return subject;
    }

    public int getComment() {
        return comment;
    }
}
