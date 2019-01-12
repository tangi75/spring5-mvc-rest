package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerDTO {
    private String firstname;
    private String lastname;
    //@JsonProperty("customer_url")
    private String customerUrl;
}
