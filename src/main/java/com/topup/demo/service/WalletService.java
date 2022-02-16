package com.topup.demo.service;

import com.topup.demo.exception.WalletNotFoundException;
import com.topup.demo.model.Wallet;

/**
 * @author HowaydaGamal
 * @created 2/16/2022
 */
public interface WalletService {

    Wallet findById(String id) throws WalletNotFoundException;

    Wallet save(Wallet wallet);
}
