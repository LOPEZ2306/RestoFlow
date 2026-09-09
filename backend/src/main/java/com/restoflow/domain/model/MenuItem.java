package com.restoflow.domain.model;

import com.restoflow.domain.vo.Money;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class MenuItem {
    private UUID id;
    private MenuCategory category;
    private String name;
    private String description;
    private Money price;
    private boolean available;
    private String imageUrl;
}
