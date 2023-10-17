package lk.ijse.gdse63.aad.package_service.repo;

import lk.ijse.gdse63.aad.package_service.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepo extends JpaRepository<Package, String> {
}
