package com.dmm.framework.modules.spider;

import com.dmm.framework.modules.user.entity.UserInfo;
import com.dmm.framework.modules.user.service.UserInfoService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by dmm on 2017/2/9.
 */
@Component
public class ParsePageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    @Autowired
    private UserInfoService userInfoService;
    @Override
    public void process(Page page) {
        JSONObject json=new JSONObject(page.getJson().toString());
        System.out.println(json.toString());
        JSONArray array=json.getJSONArray("data");
        for(int i=0;i<array.length();i++){
            JSONObject jb=array.getJSONObject(i);
            if(jb!=null){
                String zhihuId=jb.getString("id");
                String name=jb.getString("name");
                String userType=jb.getString("user_type");
                String urlToken=jb.getString("url_token");
                String avatarUrl=jb.getString("avatar_url");
                String headline=jb.getString("headline");
                int followNum=jb.getInt("follower_count");
                UserInfo userInfo=new UserInfo();
                userInfo.setZhihuId(zhihuId);
                userInfo.setNickName(name);
                userInfo.setType(userType);
                userInfo.setUrlToken(urlToken);
                userInfo.setAvatarUrl(avatarUrl);
                userInfo.setHeadline(headline);
                userInfo.setFollowNum(followNum);
                userInfo.setIsGrab("0");
                saveUserInfo(userInfo);
            }
        }

    }

    @Override
    public Site getSite() {
        site.addHeader("authorization", "Bearer Mi4wQUZEQy1vYVJMUXNBa01LaUw0SkpDeGNBQUFCaEFsVk5UNnJFV0FDdkkwTDB0LTZGdnoySl9pMHFNWDVObWJCSFZR|1486691668|98c8b6c07aa7775b9455f69b3c9fb133bea41efe");
        return site;
    }

    public static void main(String[] args) {
        //String aa=HttpKitUtils.get("https://www.zhihu.com/api/v4/members/meng-xiao-hui-30/followers?include=data%5B*%5D.answer_count%2Carticles_count%2Cfollower_count%2Cis_followed%2Cis_following%2Cbadge%5B%3F(type%3Dbest_answerer)%5D.topics&offset=0&limit=20");
        //System.out.println(aa);
        for(int i=0;i<54;i++){
            Spider.create(new ParsePageProcessor())
                    .addUrl("https://www.zhihu.com/api/v4/members/meng-xiao-hui-30/followers?include=data%5B*%5D.answer_count%2Carticles_count%2Cfollower_count%2Cis_followed%2Cis_following%2Cbadge%5B%3F(type%3Dbest_answerer)%5D.topics&offset="+i*20+"&limit=20").thread(5).run();
        }

    }

    public void saveUserInfo(UserInfo userInfo){
        String zhihuId=userInfo.getZhihuId();
        UserInfo user=userInfoService.getUserInfo(zhihuId);
        if(user==null){
            userInfoService.insertUserInfo(userInfo);
        }

    }
}
