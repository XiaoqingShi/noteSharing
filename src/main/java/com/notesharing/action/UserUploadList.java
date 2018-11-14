package com.notesharing.action;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.notesharing.model.Photo;
import com.notesharing.model.Photos;
import com.notesharing.service.UserServiceI;
import com.notesharing.superAction.SuperAction;
import com.opensymphony.xwork2.ActionContext;

/**
 * 上传图片
 * 
 * @author movw
 *
 */
@ParentPackage("jsonPackage")
@Action(value = "userUploadList")
@Namespace("/") // 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
@Results({ @Result(name = "success", type = "json", params = { "root", "dataMap" }),
		@Result(name = "error", location = "/user/login_failure.jsp") })
public class UserUploadList extends SuperAction {
	private File[] image; // 上传的文件
	private String[] imageFileName; // 文件名称
	private String[] imageContentType; // 文件类型
	private List<String> userlist;

	/**
	 * 获取本地IP地址
	 *
	 * @throws SocketException
	 */
	public static String getLocalIP() throws UnknownHostException, SocketException {
		if (isWindowsOS()) {
			return InetAddress.getLocalHost().getHostAddress();
		} else {
			return getLinuxLocalIp();
		}
	}

	/**
	 * 判断操作系统是否是Windows
	 *
	 * @return
	 */
	public static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

	/**
	 * 获取本地Host名称
	 */
	public static String getLocalHostName() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostName();
	}

	/**
	 * 获取Linux下的IP地址
	 *
	 * @return IP地址
	 * @throws SocketException
	 */
	private static String getLinuxLocalIp() throws SocketException {
		String ip = "";
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				String name = intf.getName();
				if (!name.contains("docker") && !name.contains("lo")) {
					for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
						InetAddress inetAddress = enumIpAddr.nextElement();
						if (!inetAddress.isLoopbackAddress()) {
							String ipaddress = inetAddress.getHostAddress().toString();
							if (!ipaddress.contains("::") && !ipaddress.contains("0:0:")
									&& !ipaddress.contains("fe80")) {
								ip = ipaddress;
								System.out.println(ipaddress);
							}
						}
					}
				}
			}
		} catch (SocketException ex) {
			System.out.println("获取ip地址异常");
			ip = "127.0.0.1";
			ex.printStackTrace();
		}
		System.out.println("IP:" + ip);
		return ip;
	}

	@Autowired
	private UserServiceI userService;
	private String author;
	private String up_info;
	private Map<String, Object> dataMap;
	private String tag1;
	private String tag2;
	private String tag3;
	private String introduce;

	public String execute() throws Exception {
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		userlist = new ArrayList<String>();
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		System.out.println(realpath);
		Photos photos = new Photos();
		if (image != null) {
			File savedir = new File(realpath);
			if (!savedir.getParentFile().exists())
				savedir.getParentFile().mkdirs();
			Date date = new Date();
			String time = String.valueOf(date.getTime());// 按时间存图片
			int a = 0;
			for (int i = 0; i < image.length; i++) {
				String[] aStrings = imageFileName[i].split("\\.");
				// System.out.println(new Date().toString());
				File savefile = new File(savedir, time + "_" + i + "." + aStrings[aStrings.length - 1]);
				String saveName = time + "_" + i + "." + aStrings[aStrings.length - 1];
				FileUtils.copyFile(image[i], savefile);
				// InetAddress address = InetAddress.getLocalHost();// 获取的是本地的IP地址
				// //PC-20140317PXKX/192.168.0.121
				String hostAddress = getLocalIP();// 192.168.0.121
				System.out.println(hostAddress);
				// String path = request.getScheme() + "://" + hostAddress + ":" +
				// request.getServerPort()
				// + request.getContextPath() + "/images/" + saveName;
				String path = "/images/" + saveName;
				System.out.println(path);
				if (i == 0) {

					photos.setAuthor(author);
					photos.setAddress(path);
					photos.setTag1(tag1);
					photos.setTag2(tag2);
					photos.setTag3(tag3);
					photos.setIntroduce(introduce);
					photos.setCount(image.length);
					userService.save(photos);
					a = photos.getPhotosid();
					System.out.println(photos.getPhotosid());
				}
				Photo photo = new Photo();
				photo.setAddress(path);
				photo.setPhotosid(a);
				userService.save(photo);
				userlist.add(path);
			}
			ActionContext.getContext().put("message", "文件上传成功");
			up_info = "上传成功";
			dataMap.put("login_info", up_info);
			dataMap.put("photos", photos);
		}
		return "success";
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public List<String> getUserlist() {
		return userlist;
	}

	public File[] getImage() {
		return image;
	}

	public void setImage(File[] image) {
		this.image = image;
	}

	public String[] getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String[] imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String[] getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}

}
