package com.atguigu.mvcapp.servlet;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.atguigu.mvcapp.dao.factory.CustomerDAOFactory;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init() throws ServletException {
		CustomerDAOFactory.getInstance().setType("jdbc");
		
		//��ȡ��·���µ�switch.properties�ļ�
		InputStream in = 
				getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
		
		Properties properties = new Properties();
		
		try {
			//properties��/WEB-INF/classes/switch.properties·���µ��ļ���������
			properties.load(in);
			//��ȡswitch.properties��type����ֵ
			String type = properties.getProperty("type");
			//��ֵCustomerDAOFactory��type����ֵ
			CustomerDAOFactory.getInstance().setType(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}