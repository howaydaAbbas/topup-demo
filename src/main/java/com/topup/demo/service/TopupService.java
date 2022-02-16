package com.topup.demo.service;

import com.topup.demo.model.request.TopupRequest;
import com.topup.demo.model.response.TopupResponse;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */
public interface TopupService {

    TopupResponse topup(TopupRequest topupRequest);
}
