package io.github.skshiydv.studyjam.repositories;

import io.github.skshiydv.studyjam.entities.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ListEntity,Long> {
}
