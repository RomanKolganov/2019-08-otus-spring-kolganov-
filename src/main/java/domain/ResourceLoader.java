package domain;

import org.springframework.core.io.Resource;

public class ResourceLoader {
    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
