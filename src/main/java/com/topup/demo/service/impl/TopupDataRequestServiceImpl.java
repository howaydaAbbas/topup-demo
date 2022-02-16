package com.topup.demo.service.impl;

import com.topup.demo.model.TopupData;
import com.topup.demo.model.request.TopupRequest;
import com.topup.demo.repo.TopupDataRequestRepo;
import com.topup.demo.service.TopupDataRequestService;
import org.springframework.stereotype.Service;

/**
 * @author HowaydaGamal
 * @created 2/16/2022
 */

@Service
public class TopupDataRequestServiceImpl implements TopupDataRequestService {

    private final TopupDataRequestRepo topupDataRequestRepo;

    public TopupDataRequestServiceImpl(TopupDataRequestRepo topupDataRequestRepo) {
        this.topupDataRequestRepo = topupDataRequestRepo;
    }

    @Override
    public TopupData saveTopupDataRequest(TopupRequest topupRequest, String status) {

        TopupData topupData = new TopupData();
        topupData.setAmount(topupRequest.getAmount());
        topupData.setChargeId(topupRequest.getChargeId());
        topupData.setCurrency(topupRequest.getCurrency());
        topupData.setCustomerId(topupRequest.getCustomer().getId());
        topupData.setWalletId(topupRequest.getCustomer().getWalletId());
        topupData.setStatus(status);
        if (topupRequest.getFees() != null) {
            topupData.setFeesAmount(topupRequest.getFees().getAmount());
            topupData.setFeesCurrency(topupRequest.getFees().getCurrency());
        }
        return topupDataRequestRepo.save(topupData);
    }
}
