package com.pojos;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Data // @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
public class User {
	private int user_id;
	private String name;
	private String email;
	private String password;
	private String role;
	

}
