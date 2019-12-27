import java.io.Serializable;
import java.util.Comparator;

/**
 * Class CourseNameComparator contains overrided compare method.
 */
public class CourseNameComparator implements Comparator, Serializable{

    /**
     * Method compares the two objects and returns an integer.
     *
     * @param o1
     * object 1
     *
     * @param o2
     * object 2
     *
     * @return
     * returns an integer.
     */
    @Override
    public int compare(Object o1, Object o2) {
        Course c1 = (Course)o1;
        Course c2 = (Course)o2;

        return c1.getCourseName().compareToIgnoreCase(c2.getCourseName());
    }

}

