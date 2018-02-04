package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.Section;
import com.rhanem.backend.persistence.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository  extends JpaRepository<Section, Long> {

    List<Section> findAllByService(Service service);
}
