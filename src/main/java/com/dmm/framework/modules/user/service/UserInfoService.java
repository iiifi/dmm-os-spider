/**
 *
 */
package com.dmm.framework.modules.user.service;

import com.dmm.framework.common.mongo.MongoBaseService;
import com.dmm.framework.modules.user.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 知乎用户Service
 * @author pzg
 * @version 2017-02-09
 */
@Service
public class UserInfoService  extends MongoBaseService<UserInfo> {
	@Autowired
	protected MongoTemplate template;

	/**
	 * 插入数据
	 * @param userInfo
	 */
	public void insertUserInfo(UserInfo userInfo) {
		template.insert(userInfo, "userInfo");
	}

	/**
	 * 按照id查询数据
	 * @param zhihuId
	 * @return
	 */
	public UserInfo getUserInfo(String zhihuId){
		Query query=new Query();
		query.addCriteria(Criteria.where("zhihuId").is(zhihuId));
		List<UserInfo> list=template.find(query, UserInfo.class, "userInfo");
		if(!list.isEmpty()){
			return list.get(0);
		}
		return  null;
	}

	/**
	 * 更新数据
	 * @param userInfo
	 * @return
	 */
	public void updateUserInfo(UserInfo userInfo){
		Query query = new Query(Criteria.where("_id").is(userInfo.getId()));
		Update up = new Update();
		up.set("isGrab", userInfo.getIsGrab());
		up.set("updateDate",new Date());
		template.updateFirst(query, up, "userInfo");
	}

	/**
	 * 查询关注者大于5的所有数据
	 * @return
	 */
	public List<UserInfo> getUserInfoList(){
		Query query=new Query(Criteria.where("followNum").gte(5)).addCriteria(Criteria.where("isGrab").is("0"));
		List<UserInfo> list=template.find(query, UserInfo.class, "userInfo");
		return  list;
	}
	
}