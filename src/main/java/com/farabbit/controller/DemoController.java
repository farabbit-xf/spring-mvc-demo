package com.farabbit.controller;

import com.farabbit.components.RedisComponent;
import com.farabbit.utils.TimeUtil;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mk")
public class DemoController {

    static final Logger logger = LogManager.getLogger(DemoController.class);

    @Autowired
    private RedisComponent redisComponent;

    @RequestMapping(value = "/topic.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String topic(ModelMap map, HttpServletRequest request,
                        @RequestParam(required = false) String groupName) {
        logger.info("a view of topic.vm..");

        redisComponent.setString("a11", "Just a test[" + TimeUtil.toDate(new Date(), TimeUtil.FORMAT_YYYY_MM_DD_HH_MM_SS));

        String value = redisComponent.getString("a11");
        logger.info("-----------, get a11 value = {}", value);
        return "mengka/topic";
    }


    @RequestMapping(value = "/saveTopic.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveTopic(ModelMap map, HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            Integer type = Integer.parseInt(request.getParameter("type"));
            String groupId = request.getParameter("groupId");
            String ctype = request.getParameter("ctype");
            String topic = request.getParameter("topic");
            String userName = request.getParameter("userName");


            Map<String, String> jsonObject = new HashMap<String, String>();
            jsonObject.put("status", "1");
            jsonObject.put("message", "保存成功!");
            map.put("result", new Gson().toJson(jsonObject));
        } catch (Throwable e) {
            logger.error("saveTopic.do error! ", e);
        }
        return "mengka/success";
    }
}
