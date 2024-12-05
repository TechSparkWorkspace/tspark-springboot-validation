package org.techspark.validation.objective;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class WishListController {

    @GetMapping("/api/wish")
    public String getWishes(
            @RequestParam @NotBlank(message = "Category must not be blank") String category) {
        return String.format("Fetching wishes in category: %s", category);
    }

    @GetMapping("/api/wish/{year}")
    public String getWishesByTargetYear(
            @PathVariable @NotBlank(message = "Year must not be blank")
            @Size(min = 2, max = 4, message = "Year must be between 2 and 4 characters")
            String year) {
        return String.format("Fetching wishes for year : %s", year);
    }

}
