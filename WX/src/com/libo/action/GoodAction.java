package com.libo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.libo.po.Goods;
import com.libo.service.Service;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 上传实物商品
 * @author 胡俊
 *	2016年10月1日 下午12:13:49
 */
@Controller
@SuppressWarnings("serial")
public class GoodAction extends ActionSupport{
	@Resource Service service;
	
	private Goods goods;
	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	@Action(value="up",results={@Result(name=SUCCESS,location="/wxht/up.jsp")})
	public String upl() throws Exception {
		String imgpath = "upload/";
		for (int i = 0; i < file.size(); ++i) {
			InputStream is = new FileInputStream(file.get(i));

			String path = ServletActionContext.getServletContext().getRealPath("/");
			System.out.println(path);
			String url=imgpath+this.getFileFileName().get(i);
			//把url放数据库
			goods.setImage(url);
			goods.setStatus(0);
			service.save(goods);
			File destFile = new File(path+imgpath, this.getFileFileName().get(i));

			OutputStream os = new FileOutputStream(destFile);

			byte[] buffer = new byte[400];

			int length = 0;

			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}

			is.close();

			os.close();
		}
		return SUCCESS;
	}




	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<File> getFile() {
		return file;
	}
	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
}

