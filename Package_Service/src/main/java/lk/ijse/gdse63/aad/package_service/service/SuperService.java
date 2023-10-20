package lk.ijse.gdse63.aad.package_service.service;


import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.response.Response;

public interface SuperService<T extends PackageDTO,ID> {
    Response save(T t);

    Response update(T t);

    Response delete(String id);

    Response search(String id);

    PackageDTO getPackage(String id);

    public Response saveVehicleIds(String Vehicleid, String Packageid);

    public Response saveHotelIds(String Hotelid, String Packageid);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response deleteHotelFromPackage(String hotelID, String packageid);

    Response deleteVehicleFromPackage(String vehicleID, String packageid);
}
