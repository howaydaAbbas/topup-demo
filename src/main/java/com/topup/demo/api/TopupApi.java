package com.topup.demo.api;

import com.topup.demo.constant.TopUpStatusEnum;
import com.topup.demo.model.request.TopupRequest;
import com.topup.demo.model.response.TopupResponse;
import com.topup.demo.service.TopupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author HowaydaGamal
 * @created 2/15/2022
 */

@RestController
@RequestMapping("/topup")
@RequiredArgsConstructor
public class TopupApi {

    private final TopupService topupService;

    @PostMapping
    public ResponseEntity<TopupResponse> topup(@RequestBody @Valid TopupRequest topupRequest) {
        TopupResponse response = topupService.topup(topupRequest);
        if (response != null && !response.getStatus().equals(TopUpStatusEnum.FAILED.name()))
            return ResponseEntity.status(HttpStatus.OK).body(response);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }
}
