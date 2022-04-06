package org.example.param.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.example.framework.common.PojoDuplicate;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


/**
 * 
 *
 * @author example
 * @email example@163.com
 * @date 2022-04-06 18:22:48
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "test.VersionCreateParam", description = "")
public class VersionCreateParam implements PojoDuplicate {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@ApiModelProperty(value = "")
	private String version;

	/**
	 * 
	 */
	@ApiModelProperty(value = "", example = "2019-01-01 09:01:01")
	private LocalDateTime updateTime;


}
