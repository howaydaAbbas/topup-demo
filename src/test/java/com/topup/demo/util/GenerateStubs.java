package com.topup.demo.util;

import com.topup.demo.constant.TopUpStatusEnum;
import com.topup.demo.model.Customer;
import com.topup.demo.model.TopupData;
import com.topup.demo.model.Wallet;
import com.topup.demo.model.request.TopupRequest;
import com.topup.demo.model.response.TopupResponse;
import com.topup.demo.service.dto.BalanceDTO;
import com.topup.demo.service.dto.CustomerDTO;

import java.time.LocalDateTime;

/**
 * @author HowaydaGamal
 * @created 2/16/2022
 */
public class GenerateStubs {

    public static TopupRequest generateTopupRequest() {

        TopupRequest topupRequest = new TopupRequest();
        topupRequest.setAmount(50.0);
        topupRequest.setCurrency("USD");
        topupRequest.setChargeId("0a17027e-d015-44f1-b9b1-a6ee7b88d659");
        topupRequest.setCustomer(generateCustomerDTO());
        return topupRequest;
    }

    public static CustomerDTO generateCustomerDTO() {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId("478a76bb-d10e-4f4c-bc13-8ec471f33cfa");
        customerDTO.setWalletId("b8ba3f65-6793-4ad2-b425-54173cf267ba");
        return customerDTO;
    }

    public static Customer generateCustomer() {

        Customer customer = new Customer();
        customer.setId("478a76bb-d10e-4f4c-bc13-8ec471f33cfa");
        return customer;
    }

    public static TopupResponse generateSuccessfulTopupResponse() {

        TopupResponse response = new TopupResponse();
        response.setId("92bd13ae-7ee9-4cab-9956-d8eb3646da38");
        response.setCreatedAt(LocalDateTime.now());
        response.setAmount(50.0);
        response.setCurrency("USD");
        response.setChargeId("0a17027e-d015-44f1-b9b1-a6ee7b88d659");
        response.setCustomer(generateCustomerDTO());
        response.setFees(null);
        BalanceDTO balanceDTO = new BalanceDTO();
        balanceDTO.setTotalAmount(100.0);
        response.setBalance(balanceDTO);
        response.setStatus(TopUpStatusEnum.SUCCESS.name());
        return response;
    }

    public static Wallet generateWallet() {

        Wallet wallet = new Wallet();
        wallet.setCurrency("USD");
        wallet.setCustomer(generateCustomer());
        wallet.setId("b8ba3f65-6793-4ad2-b425-54173cf267ba");
        wallet.setBalance(50.0);
        return wallet;
    }

    public static TopupData generateTopupData() {

        TopupData topupData = new TopupData();
        topupData.setStatus(TopUpStatusEnum.SUCCESS.name());
        topupData.setAmount(50.0);
        topupData.setCurrency("USD");
        topupData.setChargeId("0a17027e-d015-44f1-b9b1-a6ee7b88d659");
        topupData.setCustomerId("478a76bb-d10e-4f4c-bc13-8ec471f33cfa");
        topupData.setWalletId("b8ba3f65-6793-4ad2-b425-54173cf267ba");
        topupData.setCreationDate(LocalDateTime.now());
        return topupData;
    }
}
