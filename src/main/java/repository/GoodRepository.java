package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.GoodEntity;

public interface GoodRepository extends JpaRepository<GoodEntity, Integer>{

}
