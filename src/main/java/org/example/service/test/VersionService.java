package org.example.service.test;

import org.example.entity.test.VersionEntity;
import org.example.param.test.VersionQueryParam;
import org.example.param.test.VersionCreateParam;
import org.example.param.test.VersionUpdateParam;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 
 *
 * @author example
 * @email example@163.com
 * @date 2022-04-06 18:22:48
 */
public interface VersionService extends IService<VersionEntity> {

	IPage<VersionEntity> page(VersionQueryParam param);

	VersionEntity create(VersionCreateParam param);

	VersionEntity update(VersionUpdateParam param);
}

