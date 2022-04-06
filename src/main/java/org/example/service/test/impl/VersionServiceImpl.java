package org.example.service.test.impl;

import org.example.framework.common.exception.BusinessException;
import org.example.service.test.VersionService;
import org.example.entity.test.VersionEntity;
import org.example.param.test.VersionQueryParam;
import org.example.param.test.VersionCreateParam;
import org.example.param.test.VersionUpdateParam;
import org.example.mapper.test.VersionMapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author example
 * @email example@163.com
 * @date 2022-04-06 18:22:48
 */
@Service("test.versionService")
public class VersionServiceImpl extends ServiceImpl<VersionMapper, VersionEntity> implements VersionService {

	@Override
	public IPage<VersionEntity> page(VersionQueryParam param) {
		IPage<VersionEntity> page = new Page<>(param.getPageIndex(), param.getPageSize());
		VersionEntity entity = new VersionEntity();
		param.copyPropertiesTo(entity, false);
		QueryWrapper<VersionEntity> wrapper = Wrappers.query(entity);

		return page(page, wrapper);
	}


	@Override
	public VersionEntity create(VersionCreateParam param) {
		VersionEntity entity = new VersionEntity();
		param.copyPropertiesTo(entity, false);

		boolean f = save(entity);

		if (!f) {
			throw new BusinessException("创建失败");
		}

		return entity;
	}

	@Override
	public VersionEntity update(VersionUpdateParam param) {
		VersionEntity entity = getById(param.getId());
		if (entity == null) {
			throw new BusinessException("未查询到此对象");
		}

		param.copyPropertiesTo(entity, false);
		boolean f = updateById(entity);

		if (!f) {
			throw new BusinessException("修改失败");
		}

		return entity;
	}
}
