package nl.denhaag.zgwtempcataloghelper;

import nl.denhaag.zgwtempcataloghelper.data.Service;
import nl.denhaag.zgwtempcataloghelper.data.ServiceCatalog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


@RestController
public class RestApi {

    @GetMapping("/uuid{uuid}")
    public Service getByUuid(@PathParam("uuid") String uuid) {
        return getServiceByUuid(uuid);
    }

    @GetMapping("/uuids{uuidlist}")
    public ServiceCatalog getByMultipleUuid(@PathParam("uuidlist") String[] uuidlist) {
        ServiceCatalog serviceCatalog = new ServiceCatalog();
        for(String uuid:uuidlist)
            serviceCatalog.addService(getServiceByUuid(uuid));
        return serviceCatalog;
    }

    @GetMapping("/catalog")
    public ServiceCatalog getGetcatalog() {
        return ZgwCatalogHelper.catalog;
    }

    private Service getServiceByUuid(String uuid){
        return ZgwCatalogHelper.catalog.getService(uuid);
    }
}