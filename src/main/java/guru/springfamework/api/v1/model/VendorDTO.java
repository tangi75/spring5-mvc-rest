package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VendorDTO {
    private String name;
    //@JsonProperty("vendor_url")
    private String vendorUrl;
}
