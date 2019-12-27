import java.io.Serializable;
import java.util.Comparator;

public class SemesterComparator implements Comparator, Serializable{

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

        return courseCheck(c1,c2);
    }

    /**
     * An helper method to compare each case and return the proper integer.
     *
     * @param c1
     * object 1
     *
     * @param c2
     * object 2
     *
     * @return
     * returns an integer.
     */
    public int courseCheck(Course c1,Course c2){

        String s1 = c1.getSemester();
        String s2 = c2.getSemester();

        int n1=0,n2=0,k=0;
        for(int i=s1.length()-1;i>0;i--) {
            n1 += Math.pow(10,k)*Integer.parseInt(""+ s1.charAt(i));
            n2 += Math.pow(10,k)*Integer.parseInt(""+ s2.charAt(i));
            k++;
        }

        if(n1>n2)
            return 1;
        else
            if(n1<n2)
                return -1;

        else {
            if(s1.charAt(0)>s2.charAt(0))
                return -1;
            else if(s1.charAt(0)<s2.charAt(0))
                return 1;
            else
                return 0;
        }
    }
}
