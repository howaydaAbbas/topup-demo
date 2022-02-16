package com.topup.demo.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@Data
@Entity
@Table(name = "topup_data")
public class TopupData {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    private double amount;

    @NotNull
    private String currency;

    @NotNull
    private String chargeId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "wallet_id", nullable = false)
    private String walletId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Wallet wallet;

    private double feesAmount;

    private String feesCurrency;

    @Column(updatable = false)
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime creationDate;

    @NotNull
    private String status;
}
