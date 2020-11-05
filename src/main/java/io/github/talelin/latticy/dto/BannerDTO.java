package io.github.talelin.latticy.dto;

import io.github.talelin.core.annotation.Required;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BannerDTO {

    @NotBlank
    @Length(min = 2, max = 20)
    private String name;

    @Length(min = 2, max = 100)
    private String title;

    @Length(min = 2, max = 255)
    private String description;

    @Length(min = 2, max = 255)
    private String img;
}
