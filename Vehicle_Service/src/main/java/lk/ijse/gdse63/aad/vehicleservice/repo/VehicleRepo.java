package lk.ijse.gdse63.aad.vehicleservice.repo;

import lk.ijse.gdse63.aad.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}
