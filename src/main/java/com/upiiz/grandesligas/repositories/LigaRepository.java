package com.upiiz.grandesligas.repositories;

import com.upiiz.grandesligas.models.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigaRepository extends JpaRepository<Liga, Long> {
}