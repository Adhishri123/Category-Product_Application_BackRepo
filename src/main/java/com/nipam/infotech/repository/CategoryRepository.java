package com.nipam.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nipam.infotech.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
