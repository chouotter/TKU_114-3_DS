public class Course {

    private String id;
    private String name;
    private int capacity;
    private int students;

    public Course(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.students = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudents() {
        return students;
    }

    public boolean register() {
        if (students >= capacity) {
            return false;
        }
        students++;
        return true;
    }

    public boolean drop() {
        if (students <= 0) {
            return false;
        }
        students--;
        return true;
    }

    public boolean isFull() {
        return students == capacity;
    }

    @Override
    public String toString() {
        return "課程代碼：" + id +
                "\n課程名稱：" + name +
                "\n容量：" + capacity +
                "\n目前人數：" + students;
    }
}