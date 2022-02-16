package com.topup.demo.service.impl;

import com.topup.demo.exception.WalletNotFoundException;
import com.topup.demo.model.Wallet;
import com.topup.demo.repo.WalletRepo;
import com.topup.demo.service.WalletService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author HowaydaGamal
 * @created 2/16/2022
 */

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepo walletRepo;

    public WalletServiceImpl(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }

    @Override
    public Wallet findById(String id) throws WalletNotFoundException {
        Optional<Wallet> walletOptional = walletRepo.findById(id);
        if (walletOptional.isPresent())
            return walletOptional.get();
        throw new WalletNotFoundException("No wallet found with id " + id);
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepo.save(wallet);
    }
}
