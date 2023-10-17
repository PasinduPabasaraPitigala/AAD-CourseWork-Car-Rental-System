package lk.ijse.gdse63.aad.package_detail_service.service.custom;

import lk.ijse.gdse63.aad.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.package_detail_service.response.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

public interface PackageDetailService {
    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    Response save(PackageDetailDTO packageDetailDTO);

    Response update(PackageDetailDTO packageDetailDTO);

    Response delete(String s);

    Response search(String s);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
