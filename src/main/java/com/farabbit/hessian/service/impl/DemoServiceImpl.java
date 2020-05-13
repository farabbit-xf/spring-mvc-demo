package com.farabbit.hessian.service.impl;

import com.farabbit.hessian.service.DemoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Arrays;
import java.util.List;

public class DemoServiceImpl implements DemoService {

    private static final Log log = LogFactory.getLog(DemoServiceImpl.class);

    public List<String> getTestList() {
        log.info("DemoService getTestList invoke..");
        return Arrays.asList(new String[]{"test AAA","test BBB","test CCC"});
    }
}
