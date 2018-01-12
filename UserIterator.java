import java.util.List;;


public class UserIterator implements Iterator {
    private int index;
    private List<StudentModel> studentsList;

    public UserIterator(List<StudentModel> studentsList){
        this.studentsList = studentsList;      
    }
    @Override
    public boolean hasNext() { 
        if(index < studentsList.size()) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Object next() {
   
        if(this.hasNext()){
            return studentsList.get(index++);
        } else {
            return null;                
        }
    }		
}