package com.libei.controller.request;

import lombok.Data;
import org.hibernate.validator.internal.constraintvalidators.bv.past.PastValidatorForReadableInstant;

@Data
public class CollectRequest {
    private Long userId;
    private Long productId;
}
