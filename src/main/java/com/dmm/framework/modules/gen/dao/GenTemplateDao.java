/**
 *
 */
package com.dmm.framework.modules.gen.dao;

import com.dmm.framework.common.persistence.CrudDao;
import com.dmm.framework.common.persistence.annotation.MyBatisDao;
import com.dmm.framework.modules.gen.entity.GenTemplate;

/**
 * 代码模板DAO接口
 */
@MyBatisDao
public interface GenTemplateDao extends CrudDao<GenTemplate> {
	
}
