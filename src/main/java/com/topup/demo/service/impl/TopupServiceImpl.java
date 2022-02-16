package com.topup.demo.service.impl;

import com.topup.demo.constant.TopUpStatusEnum;
import com.topup.demo.exception.WalletNotFoundException;
import com.topup.demo.model.TopupData;
import com.topup.demo.model.Wallet;
import com.topup.demo.model.request.TopupRequest;
import com.topup.demo.model.response.TopupResponse;
import com.topup.demo.service.TopupDataRequestService;
import com.topup.demo.service.TopupService;
import com.topup.demo.service.WalletService;
import com.topup.demo.service.dto.BalanceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Service
@Slf4j
public class TopupServiceImpl implements TopupService {

    private final WalletService walletService;

    private final TopupDataRequestService topupDataRequestService;

    public TopupServiceImpl(WalletService walletService, TopupDataRequestService topupDataRequestService) {
        this.walletService = walletService;
        this.topupDataRequestService = topupDataRequestService;
    }

    @Override
    public TopupResponse topup(TopupRequest topupRequest) {

        log.info("Start topup for customer id {}", topupRequest.getCustomer().getId());
        TopupResponse response = new TopupResponse();
        response.setStatus(TopUpStatusEnum.FAILED.name());
        BalanceDTO balanceDTO = new BalanceDTO();
        try {
            Wallet wallet = walletService.findById(topupRequest.getCustomer().getWalletId());
            if (wallet.getCurrency().equals(topupRequest.getCurrency()) && wallet.getCustomer().getId().equals(topupRequest.getCustomer().getId())) {
                double topupAmount = topupRequest.getAmount();
                if (topupRequest.getFees() != null && wallet.getCurrency().equals(topupRequest.getFees().getCurrency())) {
                    topupAmount -= topupRequest.getFees().getAmount();
                }
                wallet.setBalance(wallet.getBalance() + topupAmount);
                walletService.save(wallet);
                response.setStatus(TopUpStatusEnum.SUCCESS.name());
            }
            balanceDTO.setTotalAmount(wallet.getBalance());
        } catch (WalletNotFoundException e) {
            log.error(e.getMessage());
        } finally {
            TopupData topupData = topupDataRequestService.saveTopupDataRequest(topupRequest, response.getStatus());
            response.setId(topupData.getId());
            response.setCreatedAt(topupData.getCreationDate());
            response.setAmount(topupRequest.getAmount());
            response.setCurrency(topupRequest.getCurrency());
            response.setChargeId(topupRequest.getChargeId());
            response.setCustomer(topupRequest.getCustomer());
            response.setFees(topupRequest.getFees());
            response.setBalance(balanceDTO);
            return response;
        }

    }
}
