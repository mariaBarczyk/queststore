public class Application {

    public static void main(String[] args){
        System.out.println("Welcome please enter your login and password"); 
        StudentDao dao = new StudentDao(); 
        dao.addStudent();
        System.out.println(dao.getStudentsList());
    }
}