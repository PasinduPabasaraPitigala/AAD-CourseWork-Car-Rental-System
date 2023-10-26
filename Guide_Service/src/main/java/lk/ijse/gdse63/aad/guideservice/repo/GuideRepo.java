package lk.ijse.gdse63.aad.guideservice.repo;

import lk.ijse.gdse63.aad.guideservice.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuideRepo extends JpaRepository<Guide,String> {
    Optional<Guide> findByGuideName(String guideName);
}
