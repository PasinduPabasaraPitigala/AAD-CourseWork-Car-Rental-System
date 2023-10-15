package lk.ijse.gdse63.aad.hotelservice.repo;

import lk.ijse.gdse63.aad.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, String> {
}
