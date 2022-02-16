package com.topup.demo.repo;

import com.topup.demo.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Repository
public interface WalletRepo extends JpaRepository<Wallet, String> {
}
