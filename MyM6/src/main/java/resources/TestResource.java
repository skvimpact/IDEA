package resources;

public class TestResource {
    private String name;
    private int age;

    public TestResource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestResource() {
        this.name = "";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Resource");
        sb.append("\n");
        sb.append("{");
        sb.append("\n");
        sb.append(" name = '" + name + "'");
        sb.append("\n");
        sb.append(" age = '" + age + "'");
        sb.append("\n");
        sb.append("}");
        return sb.toString();
    }
}
