package util;

public class ResourceManager {

    private static ResourceManager instance;

    private ResourceManager() { }

    public static ResourceManager getInstance() {
        if(instance == null) instance = new ResourceManager();
        return instance;
    }

}
