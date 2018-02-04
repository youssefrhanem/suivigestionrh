package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.ProfilInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileInfoRepository extends JpaRepository<ProfilInfo,Long> {
}
