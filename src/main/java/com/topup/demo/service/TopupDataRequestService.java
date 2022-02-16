package com.topup.demo.service;

import com.topup.demo.model.TopupData;
import com.topup.demo.model.request.TopupRequest;

/**
 * @author HowaydaGamal
 * @created 2/16/2022
 */
public interface TopupDataRequestService {

    TopupData saveTopupDataRequest(TopupRequest topupRequest, String status);
}
