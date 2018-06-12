package com.example.jsonpDemo.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsonpDemo.pojo.User;

/**
 * 
 * The class JsonBackController.
 *
 * Description:该控制器返回一串简单的json数据,json数据由一个简单的User对象组成
 *
 * @author: huangjiawei
 * @since: 2018年6月12日
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
@RestController
@RequestMapping(value = "/map")
public class JsonBackController {

	private static final Logger logger = LoggerFactory.getLogger(JsonBackController.class);

	/**
	 * 解决跨域请求数据
	 * @param response
	 * @param callbackName 前端回调函数名
	 * @return
	 */
	@RequestMapping(value = "getUser.json")
	public void getUser(HttpServletResponse response, @RequestParam String callbackName) {
		User user = new User("huangjiawei", 22);
		response.setContentType("text/javascript");
		Writer writer = null;
		try {
			writer = response.getWriter();
			writer.write(callbackName + "(");
			writer.write(user.toString());
			writer.write(");");
		} catch (IOException e) {
			logger.error("jsonp响应写入失败！ 数据：" + user.toString(), e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					logger.error("输出流关闭异常！", e);
				}
				writer = null;
			}
		}
	}
}
