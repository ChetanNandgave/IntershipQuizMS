package com.pojos;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Data // @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
public class Quiz {
	private int quiz_id;
	private String title;
	private int creator_id;
	
	
}
