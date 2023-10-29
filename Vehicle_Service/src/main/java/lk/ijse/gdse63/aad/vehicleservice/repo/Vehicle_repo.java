package lk.ijse.gdse63.aad.vehicleservice.repo;


import lk.ijse.gdse63.aad.vehicleservice.entity.Vehicle_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Vehicle_repo extends JpaRepository<Vehicle_entity,String> {
    Optional<Vehicle_entity> findByVehicleName(String vehiName);
}
