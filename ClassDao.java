import java.util.ArrayList;
import java.util.List;

public class ClassDao {

    List<ClassModel> classList = new ArrayList<>();

    public ClassModel createClass(String name) {
        return new ClassModel(name);
    }
    public void addClass(ClassModel newClass) {
        classList.add(newClass);
    }
}