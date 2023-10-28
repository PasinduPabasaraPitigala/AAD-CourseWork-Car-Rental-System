package lk.ijse.gdse63.aad.package_detail_service.repo;

import lk.ijse.gdse63.aad.package_detail_service.entity.PackageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PackageDetailRepo extends JpaRepository<PackageDetail, String> {
}
