package com.topup.demo.model.request;

import com.topup.demo.service.dto.CustomerDTO;
import com.topup.demo.service.dto.FeesDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Data
public class TopupRequest implements Serializable {

    @NotNull
    private double amount;

    @NotBlank
    private String currency;

    @NotBlank
    private String chargeId;

    @NotNull
    private CustomerDTO customer;

    private FeesDTO fees;


}
