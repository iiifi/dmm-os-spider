/**
 *
 */
package com.dmm.framework.modules.gen.dao;

import java.util.List;

import com.dmm.framework.common.persistence.CrudDao;
import com.dmm.framework.common.persistence.annotation.MyBatisDao;
import com.dmm.framework.modules.gen.entity.GenTable;
import com.dmm.framework.modules.gen.entity.GenTableColumn;

/**
 * 业务表字段DAO接口
 */
@MyBatisDao
public interface GenDataBaseDictDao extends CrudDao<GenTableColumn> {

	/**
	 * 查询表列表
	 * @param genTable
	 * @return
	 */
	List<GenTable> findTableList(GenTable genTable);

	/**
	 * 获取数据表字段
	 * @param genTable
	 * @return
	 */
	List<GenTableColumn> findTableColumnList(GenTable genTable);
	
	/**
	 * 获取数据表主键
	 * @param genTable
	 * @return
	 */
	List<String> findTablePK(GenTable genTable);
	
}
