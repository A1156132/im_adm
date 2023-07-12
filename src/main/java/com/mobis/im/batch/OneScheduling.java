package com.mobis.im.batch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.mobis.im.controller.HomeController;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


@Component("jobComponent")
public class OneScheduling {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public void jobMethod() throws Exception {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("스케줄 실행 : "+dateFormat.format(calendar.getTime()));
//		logger.debug("스케줄 실행 : "+dateFormat.format(calendar.getTime()));
	}
}
