package resources;

public class ResourcesServerController implements ResourcesServerControllerMBean{
    private final TestResource testResource;

    public ResourcesServerController(TestResource testResource) {
        this.testResource = testResource;
    }

    public String getName()  {
        return testResource.getName();
    }

    public int getAge() {
        return testResource.getAge();
    }
}
