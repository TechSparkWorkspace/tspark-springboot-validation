package org.techspark.validation.objective.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishRequest {

    @NotBlank(message = "Title must not be blank")
    @Size(min = 10, max = 50, message = "Title must be between 10 and 50 characters")
    private String title;

    @NotBlank(message = "Category must not be blank")
    private String category;

    @Min(value = 2000, message = "Year should be minimum 2000")
    @Max(value = 2024, message = "Year can be maximum 2024")
    private Long year;
}

