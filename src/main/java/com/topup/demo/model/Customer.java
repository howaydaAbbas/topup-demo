package com.topup.demo.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Data
@Entity
@Table(name = "customer")
public class Customer {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Wallet> wallet;

    @OneToMany(mappedBy = "customer")
    private List<TopupData> topupData;
}
