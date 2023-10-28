package lk.ijse.gdse63.aad.package_detail_service.service.custom.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.package_detail_service.dto.*;
import lk.ijse.gdse63.aad.package_detail_service.entity.PackageDetail;
import lk.ijse.gdse63.aad.package_detail_service.interfaces.*;
import lk.ijse.gdse63.aad.package_detail_service.repo.PackageDetailRepo;
import lk.ijse.gdse63.aad.package_detail_service.response.Response;
import lk.ijse.gdse63.aad.package_detail_service.service.custom.PackageDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PackageDetailServiceImpl implements PackageDetailService {

    @Autowired
    private PackageDetailRepo packageDetails_repo;

    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;




    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<PackageDetail> packageDetailEntity=packageDetails_repo.findById(id);
        if (packageDetailEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(),"Sucess", modelMapper.map(packageDetailEntity.get(),PackageDetailDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(), null,"No foound PackageDetaisl");
    }

    @Override
    public ResponseEntity<Response> save(PackageDetailDTO packageDetailsDto) {
        if (search(String.valueOf(packageDetailsDto.getPackageID())).getBody().getData()==null){
            packageDetails_repo.save(modelMapper.map(packageDetailsDto,PackageDetail.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Sucess",null);
        }
        throw new RuntimeException("No save packageDetails");
    }

    @Override
    public ResponseEntity<Response> update(PackageDetailDTO packageDetailsDto) {
        if (search(String.valueOf(packageDetailsDto.getPackageID())).getBody().getData()!=null){
            packageDetails_repo.save(modelMapper.map(packageDetailsDto,PackageDetail.class));
            return createAndSendResponse(HttpStatus.OK.value(),"success",null);
        }
        throw new RuntimeException("packagedetails no update");
    }

    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData()!=null){
            packageDetails_repo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(), "Delete success",null);
        }
        throw new RuntimeException("NOT delete by id packagedetails");
    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<PackageDetail>packageDetailEntities=packageDetails_repo.findAll();
        if (packageDetailEntities.isEmpty()){
            ArrayList<PackageDetailDTO>packageDetailsDtos=new ArrayList<>();
            packageDetailEntities.forEach(packageDetailEntity -> {
                packageDetailsDtos.add(modelMapper.map(packageDetailEntity,PackageDetailDTO.class));
            });
            return createAndSendResponse(HttpStatus.OK.value(), "Sucess get All packagedetails",null);
        }
        throw new RuntimeException("no get allpackagedetails");
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        return null;
    }


}
