package org.techspark.validation.objective;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.techspark.validation.objective.dto.WishRequest;


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

    @PostMapping("/api/wish")
    public String createWish(@RequestBody @Validated WishRequest wishRequest) {
        return String.format("Wish created: %s, Category: %s", wishRequest.getTitle(), wishRequest.getCategory());
    }

}
