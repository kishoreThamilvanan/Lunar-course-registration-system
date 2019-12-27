import java.io.*;
import java.util.*;

/**
 * class Lunar System contains the main driver for the program.
 */
public class LunarSystem {
    private static HashMap<String, Student>database =
            new HashMap<String, Student>();

    /**
     * Method returns the user entered character.
     *
     * @return
     * returns a character.
     */
    public static char mainMenu(){

        Scanner input = new Scanner(System.in);
        System.out.println("\n\n\t\tMain Menu\nL) Login.");
        System.out.println("X) Save state and quit.");
        System.out.println("Q) Quit without saving.");

        System.out.print("Please enter an option: ");
        char w = input.next().charAt(0);

        if(w=='L'||w=='l') {
            System.out.print("\nEnter Webid: ");
            String id = input.next();

            if (id.equalsIgnoreCase("REGISTRAR")) {
                System.out.println("\nWelcome Registrar.");
                char z;
                do {

                    System.out.println("\n\nR) Register a Student.");
                    System.out.println("D) De-register a Student.");
                    System.out.println("E) View course enrollment.");
                    System.out.println("L) Logout.");

                    System.out.print("Please enter an option: ");
                    z = input.next().charAt(0);

                    if (z == 'r' || z == 'R') {
                        System.out.print("\nEnter the WebId for " +
                                "the new Student: ");

                        int flag = 0;
                        String webid = input.next();
                        for (Map.Entry<String, Student> s :
                                database.entrySet())
                            if (s.getKey().equals(webid)) {
                                flag = 1;
                                break;
                            }

                        if (flag == 1)
                            System.out.print("Student is already registered.");
                        else {
                            database.put(webid, new Student());
                            System.out.print("Student has been registered.");
                        }

                    } else if (z == 'd' || z == 'D') {
                        int flag=0;
                        System.out.print("\nEnter the WebId: ");
                        String name =input.next();

                        for (Map.Entry<String, Student> s :
                                database.entrySet())
                            if (s.getKey().equals(name)) {
                                database.remove(name);
                                System.out.print( name + " is de-registered.");
                                flag = 1;
                                break;
                            }

                        if (flag == 0)
                           System.out.print("Invalid id (Id does not exist).");

                    } else if (z == 'e' || z == 'E') {

                        System.out.print("\nPlease enter the course: ");
                        String course = input.next()+" "+input.nextInt();
                        System.out.print("\nStudent\t\tSemester\n" +
                                "---------------------\n");

                        /**
                         * looping through every hashMap value.
                         */
                        for (Map.Entry<String, Student> s :
                                database.entrySet()) {

                            String c;
                            /**
                             * looping through all the courses to find out the
                             *         user required course.
                             */
                            for (int i = 0; i < s.getValue().getCourses()
                                    .size(); i++) {
                                c = s.getValue().getCourses().get(i).
                                        getCourseName();

                                if (c.equalsIgnoreCase(course)) {
                                    System.out.println(s.getKey() +
                                            "\t\t" + s.getValue().getCourses()
                                            .get(i).getSemester());
                                }
                            }
                        }
                    }  else if (z == 'l' || z == 'L')
                        System.out.print("\nREGISTRAR logged out.");

                    else
                        System.out.print("\nInvalid option.");

                } while (z != 'l' && z != 'L');
            } else {
                char v ='l'; int flag=0;
                    for (Map.Entry<String, Student> s : database.entrySet()) {
                        if (s.getKey().equals(id)) {

                            System.out.print("\nWelcome " + id);
                            Student t = s.getValue();
                            do {
                                System.out.print("\n\nOptions: " +
                                        "\n\tA) Add a class." +
                                        "\n\tD) Drop a class." +
                                        "\n\tC) View your classes sorted by " +
                                        "course name/department." +
                                        "\n\tS) View your courses sorted by " +
                                        "semester." +
                                        "\n\tL) Logout." +
                                        "\nPlease enter an option: ");
                                v = input.next().charAt(0);
                                Course c = new Course();

                                if (v == 'A' || v == 'a') {


                                    System.out.print("\nPlease enter " +
                                            "a course name: ");

                                    String cName = input.next() +
                                            " " + input.nextInt();
                                    c.setCourseName(cName);

                                    int bug=0;
                                    for (Course course : t.getCourses())
                                    if(course.getCourseName().equals(cName)) {
                                        System.out.print("\nYou have already "+
                                                "registered for the course.");
                                        bug++;
                                        break;
                                    }

                                    if(bug==0) {
                                        System.out.print("Please enter the " +
                                                "semester: ");
                                        c.setSemester(input.next());

                                        t.getCourses().push(c);
                                        System.out.print(c.getCourseName() +
                                                " added in the " +
                                                c.getSemester() + "\n");
                                    }
                                } else if (v == 'D' || v == 'd') {
                                    System.out.print("\nPlease enter" +
                                            " the course name: ");
                                    String cName = input.next()+
                                            " " + input.nextInt();

                                    int bug=0;
                                    for (Course course : t.getCourses()) {
                                        if (course.getCourseName().
                                                equalsIgnoreCase(cName)) {
                                            System.out.print(course.
                                                    getCourseName() +
                                                    " is removed.");
                                            t.getCourses().remove(course);
                                            bug++;
                                        }

                                    }
                                    if(bug==0)
                                       System.out.print("\nCourse not found.");

                                } else if (v == 'c' || v == 'C') {

                                    java.util.LinkedList<Course>
                                            courses = t.getCourses();

                                    if (courses.size() == 0)
                                        System.out.print("EMPTY.");

                                    else {
                                        System.out.print("\nDept.\tCourse\t" +
                                                "Semester" +
                                                "\n------------------------\n");

                                        Collections.sort(courses,
                                                new CourseNameComparator());

                                        for (Course course : courses) {
                                            System.out.println(course.
                                                    getDepartment() + "\t\t"
                                                    + course.getNumber() +
                                                    "\t\t" + course.
                                                    getSemester());

                                        }
                                    }
                                } else if (v == 's' || v == 'S') {

                                  System.out.print("\nDept.\tCourse\tSemester"+
                                            "\n------------------------\n");

                                    java.util.LinkedList<Course> courses =
                                            t.getCourses();
                                    Collections.sort(courses,
                                            new SemesterComparator());

                                    for (Course course : courses)
                                        System.out.println(course.
                                                getDepartment() + "\t\t"
                                                + course.getNumber() +
                                                "\t\t" + course.getSemester());
                                } else if(v == 'L' || v == 'l')
                                    System.out.print("\n"+s.getKey()+" logged"+
                                            " out safely.");

                                else
                                    System.out.print("\nInvalid option.");

                                flag++;
                            } while (v != 'l' && v != 'L');

                        }
                    }
                if(flag==0)
                    System.out.print("\nInvalid Id.");
            }

        }
            /**
             * save and quit function.
             */
        else if (w == 'X' || w == 'x') {
            try {
                File file = new File("LunarSystemData.obj");
                FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream o = new ObjectOutputStream(f);

                o.writeObject(database);
                o.close();

            } catch(FileNotFoundException e){
            } catch(IOException e){
                System.out.print(e);
            };

                System.out.print("\nThe program is saved and going to " +
                        "shut down.");
            }

        else if(w == 'q' || w == 'Q')
            System.out.print("\nThank you for using the Course " +
                    "selection program.");

        else
            System.out.print("\nInvalid option.");


        return w;
    }


    /**
     * Main method
     *
     * @param args
     * user entered arguments.
     */
    public static void main(String[] args){




        System.out.print("\nWelcome to lunar space System, a " +
                "second space course registration " +
                "system for second rate courses at a second class school.");
        char y;

        File f = new File("LunarSystemData.obj");
        if(f.exists()){
            try{
                FileInputStream inputFile = new FileInputStream(f);
                ObjectInputStream i = new ObjectInputStream(inputFile);

                database = (HashMap<String, Student>) i.readObject();
                i.close();
                System.out.print("\n\nPrevious data loaded.");
            }catch(Exception e){
                e.printStackTrace();
            };
        }


        do {
        y = mainMenu();
        }while(y!='x'&&y!='X'&&y!='q'&&y!='Q');

    }
}
