package org.example.controller.back.test;

import org.example.service.test.VersionService;
import org.example.param.test.VersionQueryParam;
import org.example.param.test.VersionCreateParam;
import org.example.param.test.VersionUpdateParam;
import org.example.entity.test.VersionEntity;
import org.example.dto.test.VersionDto;

import org.example.framework.common.ResponseEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;


/**
 * 
 *
 * @author example
 * @email example@163.com
 * @date 2022-04-06 18:22:48
 */
@Api(value = "test.VersionController", tags = {""})
@RestController("test.BackVersionController")
@RequestMapping("/api/back/test/version")
public class BackVersionController {

	@Autowired
	private VersionService versionService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表", notes = "作者：example")
    @RequiresPermissions("test:version:list")
    @GetMapping("/list")
    public ResponseEntity<IPage<VersionDto>> list(VersionQueryParam param) {

        IPage<VersionEntity> pageList = versionService.page(param);

        // 多一步转换操作，因不推荐直接返回Entity
        IPage<VersionDto> convert = pageList.convert((item)->item.copyPropertiesTo(new VersionDto(), false));

        return ResponseEntity.success(convert);
    }

    /**
     * 详情
     */
    @ApiOperation(value = "详情", notes = "作者：example")
    @RequiresPermissions("test:version:detail")
    @GetMapping("/{id}")
    public ResponseEntity<VersionDto> detail(@PathVariable("id") Integer id) {

        VersionEntity version = versionService.getById(id);

        VersionDto versionDto = version.copyPropertiesTo(new VersionDto(), false);

        return ResponseEntity.success(versionDto);
    }

    /**
     * 添加
     */
    @ApiOperation(value = "新增", notes = "作者：example")
    @RequiresPermissions("test:version:create")
    @PostMapping("")
    public ResponseEntity<VersionDto> create(@Validated @RequestBody VersionCreateParam param) {

		VersionEntity versionEntity = versionService.create(param);
		if (versionEntity == null) {
			return ResponseEntity.error("添加失败");
		}
		
        VersionDto versionDto = versionEntity.copyPropertiesTo(new VersionDto(), false);

        return ResponseEntity.success(versionDto, "添加成功");

    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改", notes = "作者：example")
    @RequiresPermissions("test:version:update")
    @PutMapping("")
    public ResponseEntity<VersionDto> update(@Validated @RequestBody VersionUpdateParam param) {
		VersionEntity versionEntity = versionService.update(param);
		if (versionEntity == null) {
			return ResponseEntity.error("修改失败");
		}

        VersionDto versionDto = versionEntity.copyPropertiesTo(new VersionDto(), false);

        return ResponseEntity.success(versionDto, "修改成功");

    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除", notes = "作者：example")
    @RequiresPermissions("test:version:delete")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {

        versionService.removeById(id);

        return ResponseEntity.success("删除成功");
    }

}
