package com.example.jpademo.domain.delivery;

import lombok.Getter;

@Getter
public enum DeliveryStatus {

    READY("준비"),
    COMP("배송") ;

    private String msg;

    DeliveryStatus(String msg) {
        this.msg = msg;
    }
}
