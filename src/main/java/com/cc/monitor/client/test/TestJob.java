package com.cc.monitor.client.test;

import com.cc.monitor.client.annotation.LMCReportor;
import com.cc.monitor.client.schedule.AbstractReportor;

@LMCReportor(name = "testJob",interval = 10,delay = 5)
public class TestJob extends AbstractReportor {

}
