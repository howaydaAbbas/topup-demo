package com.topup.demo.service.impl;

import com.topup.demo.constant.TopUpStatusEnum;
import com.topup.demo.exception.WalletNotFoundException;
import com.topup.demo.model.response.TopupResponse;
import com.topup.demo.service.TopupDataRequestService;
import com.topup.demo.service.WalletService;
import com.topup.demo.util.GenerateStubs;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HowaydaGamal
 * @created 2/16/2022
 */

@RunWith(SpringRunner.class)
public class TopupServiceImplTest {

    @Mock
    WalletService walletService;

    @Mock
    TopupDataRequestService topupDataRequestService;

    @InjectMocks
    TopupServiceImpl topupService;

    @Test
    public void topupSuccessTest() throws WalletNotFoundException {

        Mockito.when(walletService.findById("b8ba3f65-6793-4ad2-b425-54173cf267ba")).thenReturn(GenerateStubs.generateWallet());
        Mockito.when(topupDataRequestService.saveTopupDataRequest(GenerateStubs.generateTopupRequest(), TopUpStatusEnum.SUCCESS.name())).thenReturn(GenerateStubs.generateTopupData());
        TopupResponse response = topupService.topup(GenerateStubs.generateTopupRequest());
        Assertions.assertEquals(response.getStatus(), TopUpStatusEnum.SUCCESS.name());
    }
}
