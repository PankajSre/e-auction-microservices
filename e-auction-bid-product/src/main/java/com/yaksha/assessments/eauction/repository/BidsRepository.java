package com.yaksha.assessments.eauction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaksha.assessments.eauction.entity.BidsEntity;

@Repository
public interface BidsRepository extends JpaRepository<BidsEntity, Long> {

	List<BidsEntity> getBidsByProductId(Long productId);
}
