package com.topup.demo.service.mapper;

import com.topup.demo.model.Customer;
import com.topup.demo.service.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
}
