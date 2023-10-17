package lk.ijse.gdse63.aad.package_detail_service.service;

import lk.ijse.gdse63.aad.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.package_detail_service.response.Response;

public interface SuperService <T extends PackageDetailDTO,ID> {
    Response save(PackageDetailDTO packageDetailDTO);

    Response update(PackageDetailDTO packageDetailDTO);

    Response delete(String s);

    Response search(String s);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
