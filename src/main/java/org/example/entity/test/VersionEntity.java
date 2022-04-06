package org.example.entity.test;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;
import lombok.*;

import org.example.framework.common.PojoDuplicate;
import org.example.framework.mybatisplus.BaseModel;

/**
 * 
 *
 * @author example
 * @email example@163.com
 * @date 2022-04-06 18:22:48
 */
@TableName(value = "t_version", autoResultMap = true)
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VersionEntity extends BaseModel<VersionEntity> implements PojoDuplicate {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 
	 */
	private String version;

	/**
	 * 
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 
	 */
	private LocalDateTime updateTime;

	/**
	 * 
	 */
	@TableLogic
	private Integer deleted;

}
