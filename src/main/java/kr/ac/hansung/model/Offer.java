package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Offer {
	
	//@NotEmpty(message="year cannot be empty")
	private int year;
	
	//@NotEmpty(message="semester cannot be empty")
	private int semester;
	
	@NotEmpty(message="code cannot be empty")
	private String code;
	
	@NotEmpty(message="name cannot be empty")
	private String name;
	
	@NotEmpty(message="seperation cannot be empty")
	private String seperation;
	
	//@NotEmpty(message="credit cannot be empty")
	private int credit;
}
