package com.zkrallah.zshop.product;

import java.time.LocalDate;

public interface Expirable {
    Boolean isExpired();

    void setExpiryDate(LocalDate date);
}
