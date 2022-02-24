package nl.denhaag.zgwtempcataloghelper;
import nl.denhaag.zgwtempcataloghelper.data.ServiceCatalog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.io.IOException;

@SpringBootApplication
public class ZgwCatalogHelper {

    public static ServiceCatalog catalog = null;
    public static void main(String[] args) {
        try {
            ZgwCatalogHelper.catalog = loadXml();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SpringApplication.run(ZgwCatalogHelper.class, args);


    }

    public static ServiceCatalog loadXml() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(ServiceCatalog.class);
        return (ServiceCatalog) context.createUnmarshaller()
                .unmarshal(ZgwCatalogHelper.class.getClassLoader().getResourceAsStream("catalog.xml"));
    }

}
