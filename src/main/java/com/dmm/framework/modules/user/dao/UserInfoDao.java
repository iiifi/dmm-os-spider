/**
 *
 */
package com.dmm.framework.modules.user.dao;

import com.dmm.framework.common.persistence.CrudDao;
import com.dmm.framework.common.persistence.annotation.MyBatisDao;
import com.dmm.framework.modules.user.entity.UserInfo;

/**
 * 知乎用户DAO接口
 * @author pzg
 * @version 2017-02-09
 */
@MyBatisDao
public interface UserInfoDao extends CrudDao<UserInfo> {
	
}