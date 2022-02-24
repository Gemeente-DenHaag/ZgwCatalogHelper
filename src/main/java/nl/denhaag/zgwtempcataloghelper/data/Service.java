package nl.denhaag.zgwtempcataloghelper.data;

import javax.xml.bind.annotation.XmlElement;

public class Service {
    String name;
    String uuid;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
