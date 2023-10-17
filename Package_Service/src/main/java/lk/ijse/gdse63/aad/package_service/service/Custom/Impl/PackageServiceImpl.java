package lk.ijse.gdse63.aad.package_service.service.Custom.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.entity.Package;
import lk.ijse.gdse63.aad.package_service.repo.PackageRepo;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.Custom.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PackageServiceImpl implements PackageService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageRepo packageRepo;


    @Override
    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(PackageDTO packageDTO) {
        if (search(packageDTO.getPackageId()).getData() == null) {
            packageRepo.save(modelMapper.map(packageDTO,Package.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully saved!", null);
        }
        throw new RuntimeException("Package already exists!");
    }

    @Override
    public Response update(PackageDTO packageDTO) {
        if (search(packageDTO.getPackageId()).getData() != null) {
            packageRepo.save(modelMapper.map(packageDTO, Package.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully updated!", null);
        }
        throw new RuntimeException("Package does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            packageRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully deleted!", null);
        }
        throw new RuntimeException("Package does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<Package> Package = packageRepo.findById(s);
        if (package.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Package Successfully retrieved!", modelMapper.map(package.get(), PackageDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exists!", null);
    }

    @Override
    public Response getAll() {
        List<Package> packages = packageRepo.findAll();
        if (!packages.isEmpty()) {
            ArrayList<PackageDTO> packageDTOS = new ArrayList<>();
            packages.forEach((package) -> {
                packageDTOS.add(modelMapper.map(packages, PackageDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Package Successfully retrieved!", packageDTOS);
        }
        throw new RuntimeException("No Package found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

}
