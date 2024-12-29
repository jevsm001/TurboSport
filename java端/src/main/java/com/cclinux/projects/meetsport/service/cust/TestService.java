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


    }

}
