package com.cclinux.projects.meetsport.service.cust;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cclinux.framework.core.mapper.UpdateWhere;
import com.cclinux.framework.core.mapper.Where;
import com.cclinux.framework.helper.FakerHelper;
import com.cclinux.framework.helper.TimeHelper;
import com.cclinux.projects.meetsport.mapper.MeetJoinMapper;
import com.cclinux.projects.meetsport.mapper.MeetMapper;
import com.cclinux.projects.meetsport.mapper.UserMapper;
import com.cclinux.projects.meetsport.model.MeetJoinModel;
import com.cclinux.projects.meetsport.model.MeetModel;
import com.cclinux.projects.meetsport.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Notes: 活动模块业务逻辑
 * @Author: cclinux0730 (weixin)
 * @Date: 2024/3/7 5:41
 * @Ver: ccminicloud-framework 3.2.1
 */

@Service("MeetSportTestService")
public class TestService extends BaseMyCustService {

    @Resource(name = "MeetSportMeetMapper")
    private MeetMapper meetMapper;

    @Resource(name = "MeetSportMeetJoinMapper")
    private MeetJoinMapper meetJoinMapper;

    @Resource(name = "MeetSportUserMapper")
    private UserMapper userMapper;


    public void test() {

       // this.testInsertUsers();
        this.testInsertMeetJoins();
    }

    public void testInsertMeetJoins() {

        List<MeetModel> list = meetMapper.getAllList(null, "*");
        meetJoinMapper.delete(null);

        Where<UserModel> where = new Where<>();
        long max = userMapper.max(where, "USER_ID");
        long min = userMapper.min(where, "USER_ID");

        String[] dayArr = {"01", "02", "03", "04", "05", "06", "11", "13", "15"};
        String[] TimeArr = {"上午(8:00~12:00)", "下午(13:00~17:00)", "晚上(19:00~22:00)"};

        logger.info(">>>>>>>>>>>>+" + min + "~" + max);
        for (MeetModel meet : list) {
            UpdateWhere<MeetModel> uw = new UpdateWhere<>();
            uw.eq("MEET_ID",meet.getMeetId());
            uw.set("MEET_VIEW_CNT",RandomUtil.randomInt(20,1000));
            meetMapper.edit(uw);


            for (int i = 0; i < RandomUtil.randomInt(5, 18); i++) {
                MeetJoinModel join = new MeetJoinModel();
                join.setMeetJoinCode(RandomUtil.randomString(15).toUpperCase());
                join.setMeetJoinForms("");

                JSONObject obj = new JSONObject();
                obj.set("name", FakerHelper.getName());
                obj.set("phone", "139" + RandomUtil.randomNumbers(8));

                JSONArray jsonArr = new JSONArray();
                JSONObject o = new JSONObject();
                o.set("mark", "name");
                o.set("title", "姓名");
                o.set("val", FakerHelper.getName());
                jsonArr.add(o);

                o = new JSONObject();
                o.set("mark", "phone");
                o.set("title", "手机");
                o.set("val", "139" + RandomUtil.randomNumbers(8));
                jsonArr.add(o);

                join.setMeetJoinForms(JSONUtil.toJsonStr(jsonArr));
                join.setMeetJoinObj(JSONUtil.toJsonStr(obj));

                join.setMeetJoinUserId(RandomUtil.randomLong(min, max));
                join.setMeetJoinStatus(1);
                join.setMeetJoinMeetTitle(meet.getMeetTitle());
                join.setMeetJoinMeetId(meet.getMeetId());

                join.setMeetJoinDay(TimeHelper.time("yyyy-MM") + "-" + RandomUtil.randomEle(dayArr));
                join.setMeetJoinTime(RandomUtil.randomEle(TimeArr));

                meetJoinMapper.add(join);
            }


        }

    }


    public void testInsertUsers() {

        userMapper.delete(null);

        for (int k = 0; k < 100; k++) {
            UserModel user = new UserModel();

            user.setUserAccount(FakerHelper.getEnWord() + FakerHelper.getEnWord() + FakerHelper.getEnWord());
            user.setUserName(FakerHelper.getName());
            user.setUserStatus(1);
            user.setUserPassword(DigestUtil.md5Hex(RandomUtil.randomString(6)));
            user.setUserLoginTime(FakerHelper.getAddTimestamp(0, 1));
            user.setUserLoginCnt(RandomUtil.randomInt(1, 100));

            String sex = FakerHelper.getSex();
            String birth = FakerHelper.getBirth("2000", "2002");


            JSONArray arr = JSONUtil.createArray();

            JSONObject obj = new JSONObject();
            JSONObject ori = new JSONObject();
            obj.set("mark", "sex");
            obj.set("title", "性别");
            obj.set("val", sex);
            ori.set("sex", sex);
            arr.add(obj);


            obj = new JSONObject();
            obj.set("mark", "birth");
            obj.set("title", "出生年月");
            obj.set("val", birth);
            ori.set("birth", birth);
            arr.add(obj);


            user.setUserObj(JSONUtil.toJsonStr(ori));
            user.setUserForms(JSONUtil.toJsonStr(arr));

            userMapper.add(user);

        }

    }
}
