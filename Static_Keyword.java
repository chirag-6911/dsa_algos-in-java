public class Static_Keyword{
    public static void main(String args[]){
        Student s1 = new Student();
        Student.SchoolName="DAV";

        Student s2 = new Student();
        System.out.println(s2.SchoolName);
        System.out.println(Student.percentage(90, 99, 100));
    }
}
class Student{
    String name;
    int roll_no;

    static int percentage(int math, int phy, int chem){
        return (math+phy+chem)/3;
    }

    static String SchoolName;

    void setname(String name){
        this.name=name;
    }

    String getname(){
        return name;
    }
    void setroll_no(int roll_no){
        this.roll_no = roll_no;
    }
    int getroll_no(){
        return roll_no;
    }
}