package com.topup.demo.model.response;

import com.topup.demo.service.dto.BalanceDTO;
import com.topup.demo.service.dto.CustomerDTO;
import com.topup.demo.service.dto.FeesDTO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Data
public class TopupResponse {

    private String id;

    private LocalDateTime createdAt;

    private String status;

    private double amount;

    private String currency;

    private String chargeId;

    private CustomerDTO customer;

    private FeesDTO fees;

    private BalanceDTO balance;
}
