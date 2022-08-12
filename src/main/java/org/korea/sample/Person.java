package org.korea.sample;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Person {
	
	private String name;
	private String age;
	private String addr;

}
