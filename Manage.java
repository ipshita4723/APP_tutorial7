package student;
public class Student{
String name;
int roll;
public Student(String name,int roll){
this.name=name;
this.roll=roll;
}
public void display(){
System.out.print("name:" + name +"\n" + "roll no:" + roll);
}
}
package course;
public class Course{
String coursename;
String code;
public Course(String coursename,String code){
this.coursename=coursename;
this.code=code;
}
public void display(){
System.out.print("Course name:" + coursename + "\n" + "course code:" + code);
}
}
import student.Student;
import course.Course;
public class Manage{
public static void main(String[] args){

Student s=new Student("abc",22);
Course c=new Course("app","app123");
s.display();
c.display();
}
