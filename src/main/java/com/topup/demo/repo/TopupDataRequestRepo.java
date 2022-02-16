package com.topup.demo.repo;

import com.topup.demo.model.TopupData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Repository
public interface TopupDataRequestRepo extends JpaRepository<TopupData, String> {
}
