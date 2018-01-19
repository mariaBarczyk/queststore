import java.util.ArrayList;
import java.util.List;

public class ClassDao {

    List<ClassModel> classList = new ArrayList<>();

    public ClassModel createClass(String name) {
        ClassModel newClass = new ClassModel(name);
        addClass(newClass);
        return newClass;
    }
    public void addClass(ClassModel newClass) {
        classList.add(newClass);
    }
    public void importClassData() {
        ClassModel class1 = new ClassModel("Group1");
        ClassModel class2 = new ClassModel("Group2");
        addClass(class1);
        addClass(class2);

    }
}