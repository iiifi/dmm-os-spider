/**
 *
 */
package com.dmm.framework.modules.user.web;

import com.dmm.framework.common.web.BaseController;
import com.dmm.framework.modules.spider.ParsePageProcessor;
import com.dmm.framework.modules.user.entity.UserInfo;
import com.dmm.framework.modules.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

import java.util.List;

/**
 * 知乎用户Controller
 * @author pzg
 * @version 2017-02-09
 */
@Controller
@RequestMapping(value = "${adminPath}/user/userInfo")
public class UserInfoController extends BaseController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	protected MongoTemplate template;

	@Autowired
	private ParsePageProcessor parsePageProcessor;

/*	@ModelAttribute
	public UserInfo get(@RequestParam(required=false) String id) {
		UserInfo entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = userInfoService.get(id);
		}
		if (entity == null){
			entity = new UserInfo();
		}
		return entity;
	}
	
	@RequiresPermissions("user:userInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(UserInfo userInfo, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<UserInfo> page = userInfoService.findPage(new Page<UserInfo>(request, response), userInfo); 
		model.addAttribute("page", page);
		return "modules/user/userInfoList";
	}

	@RequiresPermissions("user:userInfo:view")
	@RequestMapping(value = "form")
	public String form(UserInfo userInfo, Model model) {
		model.addAttribute("userInfo", userInfo);
		return "modules/user/userInfoForm";
	}

	@RequiresPermissions("user:userInfo:edit")
	@RequestMapping(value = "save")
	public String save(UserInfo userInfo, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, userInfo)){
			return form(userInfo, model);
		}
		userInfoService.save(userInfo);
		addMessage(redirectAttributes, "保存知乎用户成功");
		return "redirect:"+Global.getAdminPath()+"/user/userInfo/?repage";
	}
	
	@RequiresPermissions("user:userInfo:edit")
	@RequestMapping(value = "delete")
	public String delete(UserInfo userInfo, RedirectAttributes redirectAttributes) {
		userInfoService.delete(userInfo);
		addMessage(redirectAttributes, "删除知乎用户成功");
		return "redirect:"+Global.getAdminPath()+"/user/userInfo/?repage";
	}*/


	@RequestMapping("excute")
	@ResponseBody
	public String excute() {
		List<UserInfo> list=userInfoService.getUserInfoList();
		if(!list.isEmpty()){
			for(UserInfo user:list){
				int pageNo=1;
				if(user.getFollowNum()>20){
					pageNo+=user.getFollowNum()/20;
				}
				getText(user.getUrlToken(), pageNo);
				user.setIsGrab("1");
				userInfoService.updateUserInfo(user);
			}
		}
		//getText("meng-xiao-hui-30", 56);
		return "";
	}
	public void getText(String urlToken,int pageNo){
		for(int i=1;i<pageNo;i++){
			Spider.create(parsePageProcessor)
					.addUrl("https://www.zhihu.com/api/v4/members/"+urlToken+"/followers?include=data%5B*%5D.answer_count%2Carticles_count%2Cfollower_count%2Cis_followed%2Cis_following%2Cbadge%5B%3F(type%3Dbest_answerer)%5D.topics&offset="+i*20+"&limit=20").thread(5).run();
		}
	}
}