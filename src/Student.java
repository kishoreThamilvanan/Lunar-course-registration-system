
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Class Student contains webID of the student and a list of courses.
 */
public class Student implements Serializable{
    private String webID;// ID String of the student.
    private LinkedList<Course> courses;// list of courses.

    /**
     * Default constructor.
     */
    public Student(){
        webID = "";
        courses = new LinkedList<Course>();
    }

    /**
     * Method returns the list of all the courses.
     *
     * @return
     * returns the list of courses of the student.
     */
    public LinkedList<Course> getCourses() {
        return courses;
    }

    /**
     * Method returns webId of the student.
     *
     * @return
     * returns the webId.
     */
    public String getWebID() {
        return this.webID;
    }

    /**
     * Method sets the user entered string as webId of the student.
     *
     * @param webID
     * user entered webId.
     */
    public void setWebID(String webID) {
        this.webID = webID;
    }
}
