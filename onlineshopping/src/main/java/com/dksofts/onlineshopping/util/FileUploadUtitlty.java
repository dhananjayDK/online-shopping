package com.dksofts.onlineshopping.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtitlty {

	private static final String ABS_path="G:\\springmobileshoppee\\online-shopping\\onlineshopping\\src\\main\\webapp\\assests\\images\\";
	
	private static  String Real_path="";

	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtitlty.class);
	
	public static void uploadFile(HttpServletRequest request,
			MultipartFile file, String code) {
		//get the real path
		
		Real_path = request.getSession().getServletContext().getRealPath("/assests/images/");
		  logger.info("Error came");
		logger.info(Real_path);
		
		//make sure all the directory exists
		//please create the directory
		if(!new File(ABS_path).exists()){
			//create the directories 
			new File(ABS_path).mkdir();
		}
		if(!new File(Real_path).exists()){
			//create the directories 
			new File(Real_path).mkdir();
		}
		try{
			//for uploading to server
			file.transferTo(new File(Real_path + code + ".jpg"));
			//for uploading to database
			file.transferTo(new File(ABS_path + code + ".jpg"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
