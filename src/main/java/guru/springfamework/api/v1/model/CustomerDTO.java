package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerDTO {

    @ApiModelProperty(value = "This is the first name", required = true)
    private String firstname;

    @ApiModelProperty(required = true )
    private String lastname;

    //@JsonProperty("customer_url")
    private String customerUrl;
}
