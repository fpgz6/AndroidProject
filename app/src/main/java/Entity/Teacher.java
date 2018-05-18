package Entity;

public class Teacher
{
    private String id;
    private String password;
    private String name;
    private int gender;
    private int age;
    private String subject;//科目
    private String region;//地区
    private String alipay;//支付宝账户
    private int hour_price;//时薪
    private String pic_src;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public int getHour_price() {
        return hour_price;
    }

    public void setHour_price(int hour_price) {
        this.hour_price = hour_price;
    }


    public String getPic_src() {
        return pic_src;
    }

    public void setPic_src(String pic_src) {
        this.pic_src = pic_src;
    }
}
