package guru.springframework.api.v1.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class VendorDTO {

    @ApiModelProperty(value = "Name of the Vendor", required = true)
    private String name;
    //@JsonProperty("vendor_url")
    private String vendorUrl;
}
