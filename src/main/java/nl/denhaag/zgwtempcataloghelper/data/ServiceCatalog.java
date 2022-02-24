package nl.denhaag.zgwtempcataloghelper.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class ServiceCatalog {
    private List<Service> service = new ArrayList<>();

    @XmlElement
    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public Service getService(String uuid){
        for (Service s:service) {
            if(s.uuid.equalsIgnoreCase(uuid))
                return s;
        }
        return null;
    }

    public void addService(Service s){
        service.add(s);
    }
}
