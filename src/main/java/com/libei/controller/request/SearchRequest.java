package com.libei.controller.request;

import com.libei.enums.BlandEnum;
import lombok.Data;

@Data
public class SearchRequest {
    private String productName;
    private String description;
    private BlandEnum brand;
}
