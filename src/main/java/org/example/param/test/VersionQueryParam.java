package org.example.param.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.example.framework.common.PojoDuplicate;

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
@ApiModel(value = "test.VersionQueryParam", description = "")
public class VersionQueryParam implements PojoDuplicate {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页码", example = "1")
    private int pageIndex = 1;

    @ApiModelProperty(value = "每页数量", example = "20")
    private int pageSize = 20;

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
