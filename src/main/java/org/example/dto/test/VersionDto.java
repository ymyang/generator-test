package org.example.dto.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.example.framework.common.PojoDuplicate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@ToString
@ApiModel(value="test.VersionDto", description="")
public class VersionDto implements PojoDuplicate {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    @ApiModelProperty(value = "", required = true)
	private Integer id;

	/**
	 * 
	 */
    @ApiModelProperty(value = "")
	private String version;

	/**
	 * 
	 */
    @ApiModelProperty(value = "", example = "2019-01-01 09:01:01")
	private LocalDateTime createTime;

	/**
	 * 
	 */
    @ApiModelProperty(value = "", example = "2019-01-01 09:01:01")
	private LocalDateTime updateTime;

}
