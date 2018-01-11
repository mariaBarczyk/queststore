public class Application {

    public static void main(String[] args){
        System.out.println("Welcome please enter your login and password"); 
        System.out.println("***** Students List*****\n");
        StudentDao dao = new StudentDao(); 
        dao.addStudent();
        System.out.println(dao.getStudentsList());
        System.out.println("***** Mentors List*****\n");
        MentorDao mdao = new MentorDao();
        mdao.addMentor();
        System.out.println(mdao.getMentorsList());
        System.out.println("***** Users List*****\n");
        UserDao udao = new UserDao("user_data.txt");
        //System.out.println(udao.getUsersList());
 
    }
}