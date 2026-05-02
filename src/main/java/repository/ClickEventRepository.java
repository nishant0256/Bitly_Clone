package repository;

import entity.ClickEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {

    // Get all clicks for a short URL
    List<ClickEvent> findByShortCode(String shortCode);

    // Count clicks (alternative to entity counter)
    long countByShortCode(String shortCode);
}