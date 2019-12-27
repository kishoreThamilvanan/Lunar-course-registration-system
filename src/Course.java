import java.io.Serializable;

/**
 * Class course contains the attributes of a course.
 */
public class Course implements Serializable{
    private String department;// dept of the course.
    private int number;// number of the course.
    private String semester;// semester of the course.

    /**
     * Default constructor.
     */
    public Course(){
        department ="";
        number = 0;
        semester = "";
    }

    /**
     * Parametrised constructor.
     *
     * @param dept
     * dept of the course.
     *
     * @param num
     * number of the course.
     *
     * @param sem
     * semester of the course.
     *
     */
    public Course(String dept,int num,String sem){
        department =dept;
        number = num;
        semester = sem;
    }

    /**
     * Method returns the department of the course.
     *
     * @return
     * returns the department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Methode sets the department of the course.
     *
     * @param department
     * user enetered department of the course.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Method returns the number of the course.
     *
     * @return
     * returns the number of the course.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Method sets the number of the course.
     *
     * @param number
     * user entered parameter set to the number of the course.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Method returns the semester.
     *
     * @return
     * returns the semester.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * sets the usere enetered semster to the current semester.
     *
     * @param semester
     * user entered parameter
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Method returns the course name.
     *
     * @return
     * returns the course name.
     */
    public String getCourseName(){
        return getDepartment()+" "+getNumber();
    }

    /**
     * sets the course name of the course.
     *
     * @param s
     * user entered parameter set as the course name.
     */
    public void setCourseName(String s){
        String[] n = s.split(" ");

        this.setDepartment(n[0]);
        this.setNumber(Integer.parseInt(n[1]));
    }
}
