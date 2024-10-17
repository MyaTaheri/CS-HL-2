package Assignment7;

public class Student 
{
    private String name;
    private double GPA;
    private double height;
    private int numOfIBCourses;

    public Student (String name, double GPA, double height, int numOfIBCourses)
    {
        this.name = name;
        this.GPA = GPA;
        this.height = height;
        this.numOfIBCourses = numOfIBCourses;
    }

    public String getName()
    {
        return this.name;
    } 
    public double getGpa(){
        return this.GPA;
    } 
    public int getIbCoursesTaken(){
        return this.numOfIBCourses;
    } 
    public double getHeight(){
        return this.height;
    }
    
}
