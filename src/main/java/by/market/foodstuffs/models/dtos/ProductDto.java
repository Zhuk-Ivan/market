package by.market.foodstuffs.models.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDto {

    private Long productId;

    private String productName;

    private Long categoryId;

    private String categoryName;

    private String description;

    private Double cost;

    private String notes;

    private String specialNotes;
}
