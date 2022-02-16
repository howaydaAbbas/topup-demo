package com.topup.demo.service.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Data
public class CustomerDTO implements Serializable {

    @NotBlank
    private String id;

    @NotBlank
    private String walletId;

}
