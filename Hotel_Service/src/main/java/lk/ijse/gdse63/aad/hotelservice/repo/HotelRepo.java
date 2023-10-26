package lk.ijse.gdse63.aad.hotelservice.repo;

import lk.ijse.gdse63.aad.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {
    Optional<Hotel> findByHotelName(String hotelName);
}
