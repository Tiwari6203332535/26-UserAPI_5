package in.happy.binding;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class User {
	   @JsonProperty("Id")
	private Integer Id;
	private String name;
	private String email;

}
