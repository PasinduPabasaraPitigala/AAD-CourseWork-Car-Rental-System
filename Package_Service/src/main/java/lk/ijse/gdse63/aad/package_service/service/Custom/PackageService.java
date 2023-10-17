package lk.ijse.gdse63.aad.package_service.service.Custom;

import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.SuperService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

public interface PackageService extends SuperService<PackageDTO,String> {
    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    Response save(PackageDTO packageDTO);

    Response update(PackageDTO packageDTO);

    Response delete(String s);

    Response search(String s);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
