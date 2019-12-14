package com.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.po.clothes;
import com.po.collect;
import com.po.orderform;
import com.po.pagebean;
import com.po.register;
import com.service.BizService;
import com.util.AjAxUtils;

@Controller
public class ClothesAction implements action {
	@Resource(name = "bizservice")
	private BizService bizservice;
	private String JOSNObject;

	public BizService getBizservice() {
		return bizservice;
	}

	public void setBizservice(BizService bizservice) {
		this.bizservice = bizservice;
	}

	// 服装（clothes）
	@RequestMapping(value = "save_clo.do")
	public String savec(HttpServletRequest request, HttpServletResponse response, clothes cs) {
		String realpath = request.getRealPath("/");
		/***************** 上传文件 ************************************/
		// 获取上传照片的对象
		MultipartFile multipartFile = cs.getPic();
		if (multipartFile != null && !multipartFile.isEmpty()) {
			// 获取上传的文件名称
			String fname = multipartFile.getOriginalFilename();
			// 更名
			if (fname.lastIndexOf(".") != -1) {// 存在后缀
				// 获取后缀名
				String ext = fname.substring(fname.lastIndexOf("."));

				// 判断后缀是否为jpg格式
				if (ext.equalsIgnoreCase(".jpg")) {
					// 改名
					String newfname = new Date().getTime() + ext;
					// 创建文件对象，指定上传文件的路径
					File destFile = new File(realpath + "/uppic/" + newfname);
					// 上传
					try {
						FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), destFile);
						cs.setPhoto(newfname);
						;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		/****************************************************************************/
		boolean flag = bizservice.getClothesbiz().save(cs);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "update_clo.do")
	public String updatec(HttpServletRequest request, HttpServletResponse response, clothes cs) {
		System.out.println(cs);
		String realpath = request.getRealPath("/");
		// 获取原来上传的照片
		String oldphoto = bizservice.getClothesbiz().findbyid(cs.getClid()).getPhoto();
		/***************** 上传文件 ************************************/
		// 获取上传照片的对象
		MultipartFile multipartFile = cs.getPic();
		if (multipartFile != null && !multipartFile.isEmpty()) {
			// 获取上传的文件名称
			String fname = multipartFile.getOriginalFilename();
			// 更名
			if (fname.lastIndexOf(".") != -1) {// 存在后缀
				// 获取后缀名
				String ext = fname.substring(fname.lastIndexOf("."));

				// 判断后缀是否为jpg格式
				if (ext.equalsIgnoreCase(".jpg")) {
					// 改名
					String newfname = new Date().getTime() + ext;
					// 创建文件对象，指定上传文件的路径
					File destFile = new File(realpath + "/uppic/" + newfname);
					// 上传
					try {
						FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), destFile);
						cs.setPhoto(newfname);
						// 删除原来的照片
						File oldFile = new File(realpath + "/uppic/" + oldphoto);
						if (oldFile.exists() && !oldphoto.equalsIgnoreCase("default.jpg")) {
							oldFile.delete();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} else {
			cs.setPhoto(oldphoto);
		}
		/****************************************************************************/
		boolean flag = bizservice.getClothesbiz().update(cs);
		System.out.println(cs.getClid());
		System.out.println(cs);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "delbyid_clo.do")
	public String delbyidc(HttpServletRequest request, HttpServletResponse response, Integer clid) {
		boolean flag = bizservice.getClothesbiz().delbyid(clid);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "findbyid_clo.do")
	public String findbyidc(HttpServletRequest request, HttpServletResponse response, Integer clid) {
		clothes cloth = bizservice.getClothesbiz().findbyid(clid);
		PropertyFilter propertyFilter = AjAxUtils.filterProperts("pic");
		String josnstr = JSONObject.toJSONString(cloth, propertyFilter,
				SerializerFeature.DisableCircularReferenceDetect);
		AjAxUtils.printString(response, josnstr);
		return null;
	}

	@RequestMapping(value = "findall_clo.do")
	public String findallc(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		System.out.println("11111111111111");
		Map<String, Object> map = new HashMap<String, Object>();
		pagebean pb = new pagebean();
		page = page == null ? pb.getPage() : page;
		rows = rows == null ? pb.getRows() : rows;
		pb.setPage(page);
		pb.setRows(rows);
		// 获取当前页记录集合
		List<clothes> lscs = bizservice.getClothesbiz().findall(pb);
		// 获取总记录数
		int maxrows = bizservice.getClothesbiz().findmaxrows();
		map.put("page", page);
		map.put("rows", lscs);
		map.put("total", maxrows);
		PropertyFilter propertyFilter = AjAxUtils.filterProperts("pic");
		System.out.println("55555555555555");
		String josnstr = JSONObject.toJSONString(map, propertyFilter, SerializerFeature.DisableCircularReferenceDetect);
		AjAxUtils.printString(response, josnstr);
		return null;
	}

	// 登录（register）
	@RequestMapping(value="save_reg.do")
	public String saver(HttpServletRequest request, HttpServletResponse response, register rt) {
		List<register>   lsrt=bizservice.getRegisterbiz().findalll();
		for(register r:lsrt) {
			if (r.getIid().equals(rt.getIid())||rt.getIid().equals("135790")||rt.getIid().trim()==" ") {
				AjAxUtils.printString(response,""+0);
				return null;
			}
		}
		boolean  flag=bizservice.getRegisterbiz().save(rt);
		if (flag) {
			AjAxUtils.printString(response,""+1);
		}else {
		AjAxUtils.printString(response,""+2);
		}
		return null;
	}
	@RequestMapping(value = "update_reg.do")
	public String updater(HttpServletRequest request, HttpServletResponse response, register rt) {
		List<register>   lsrt=bizservice.getRegisterbiz().findalll();
		for(register r:lsrt) {
			if (r.getIid().equals(rt.getIid())&&rt.getIid().trim()!=" ") {
				boolean flag = bizservice.getRegisterbiz().update(rt);
				if (flag) {
					AjAxUtils.printString(response, "" + 1);
					return  null;
				} else {
					AjAxUtils.printString(response, "" + 0);
					return  null;
			}
		}
		}
		AjAxUtils.printString(response, "" + 2);
		return null;
	}

	@RequestMapping(value = "delbyreg_reg.do")
	public String delbyregr(HttpServletRequest request, HttpServletResponse response, Integer regid) {
		boolean flag = bizservice.getRegisterbiz().delbyreg(regid);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}
	
	@RequestMapping(value = "delbyiid_reg.do")
	public String delbyiidr(HttpServletRequest request, HttpServletResponse response, register rt) {
		List<register>   lsrt=bizservice.getRegisterbiz().findalll();
		System.out.println(lsrt);
		for(register r:lsrt) {
			if (r.getIid().equals(rt.getIid())&&r.getPasswd().equals(rt.getPasswd())&&!rt.getIid().equals("135790")){
				boolean  flag=bizservice.getRegisterbiz().delbyid(rt.getIid());
				System.out.println(rt.getIid());
				if (flag) {
					AjAxUtils.printString(response, "" + 1);
					return  null;
				} else {
					AjAxUtils.printString(response, "" + 2);
				}
			}
			}
		AjAxUtils.printString(response, "" + 0);
		return  null;
	}

	@RequestMapping(value = "findbyid_reg.do")
	public String findbyidr(HttpServletRequest request, HttpServletResponse response, String iid) {
		register regt = bizservice.getRegisterbiz().findbyiid(iid);
		String josnstr = JSONObject.toJSONString(regt);
		AjAxUtils.printString(response, josnstr);
		return null;
	}

	@RequestMapping(value = "findall_reg.do")
	public String findallr(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		pagebean pb = new pagebean();
		page = page == null ? pb.getPage() : page;
		rows = rows == null ? pb.getRows() : rows;
		pb.setPage(page);
		pb.setRows(rows);
		// 获取当前页记录集合
		List<register> lsrt = bizservice.getRegisterbiz().findall(pb);
		// 获取总记录数
		int maxrows = bizservice.getRegisterbiz().findmaxrows();
		map.put("page", page);
		map.put("rows", lsrt);
		map.put("total", maxrows);
		String josnstr = JSONObject.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		AjAxUtils.printString(response, josnstr);
		return null;
	}
	@RequestMapping(value = "findalll_reg.do")
	public String findalllr(HttpServletRequest request, HttpServletResponse response,register rt) {
		List<register>   lsrt=bizservice.getRegisterbiz().findalll();
		for(register r:lsrt) {
			if (rt.getIid().equals("135790")&&rt.getPasswd().equals("123456")) {
				AjAxUtils.printString(response,""+2);	
				return  null;
			}else if( r.getIid().equals(rt.getIid())&&r.getPasswd().equals(rt.getPasswd())){
				AjAxUtils.printString(response,""+1);
				return null;
			}
			}
		AjAxUtils.printString(response,""+0);
		return null;
	}


	// 地址信息(collect)
	@RequestMapping(value = "save_coll.do")
	public String savet(HttpServletRequest request, HttpServletResponse response, collect ct) {
		System.out.println(ct.toString());
		boolean flag = bizservice.getCollectbiz().save(ct);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "update_coll.do")
	public String updatet(HttpServletRequest request, HttpServletResponse response, collect ct) {
		boolean flag = bizservice.getCollectbiz().update(ct);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "delbyid_coll.do")
	public String delbyidt(HttpServletRequest request, HttpServletResponse response, Integer coid) {
		boolean flag = bizservice.getCollectbiz().delbyid(coid);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "findbyid_coll.do")
	public String findbyidt(HttpServletRequest request, HttpServletResponse response, Integer coid) {
		collect coct = bizservice.getCollectbiz().findbyid(coid);
		String josnstr = JSONObject.toJSONString(coct);
		AjAxUtils.printString(response, josnstr);
		return null;
	}

	@RequestMapping(value = "findall_coll.do")
	public String findallt(HttpServletRequest request, HttpServletResponse response, Integer regid) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取当前页记录集合
		List<collect> lsct = bizservice.getCollectbiz().findall(regid);
		map.put("rows", lsct);
		String josnstr = JSONObject.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		AjAxUtils.printString(response, josnstr);
		return null;
	}

	// 订单（orderform）
	@RequestMapping(value = "save_ord.do")
	public String saveo(HttpServletRequest request, HttpServletResponse response, orderform om) {
		System.out.println(om.toString());
		boolean flag = bizservice.getOrderformbiz().save(om);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "update_ord.do")
	public String updateo(HttpServletRequest request, HttpServletResponse response, orderform om) {
		boolean flag = bizservice.getOrderformbiz().update(om);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "delbyid_ord.do")
	public String delbyido(HttpServletRequest request, HttpServletResponse response, Integer ordid) {
		boolean flag = bizservice.getOrderformbiz().delbyid(ordid);
		if (flag) {
			AjAxUtils.printString(response, "" + 1);
		} else {
			AjAxUtils.printString(response, "" + 0);
		}
		return null;
	}

	@RequestMapping(value = "findbyid_ord.do")
	public String findbyido(HttpServletRequest request, HttpServletResponse response, Integer regid) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取当前页记录集合
		List<orderform> lsct = bizservice.getOrderformbiz().findbyid(regid);
		map.put("rows", lsct);
		String josnstr = JSONObject.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		AjAxUtils.printString(response, josnstr);
		return null;
	}
	
	@RequestMapping(value = "findbyiid_ord.do")
	public String findbyiido(HttpServletRequest request, HttpServletResponse response, Integer ordid) {
		orderform lsom = bizservice.getOrderformbiz().findbyiid(ordid);
		String josnstr = JSONObject.toJSONString(lsom, SerializerFeature.DisableCircularReferenceDetect);
		AjAxUtils.printString(response, josnstr);
		return null;
	}

	@RequestMapping(value = "findall_ord.do")
	public String findallo(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		pagebean pb = new pagebean();
		page = page == null ? pb.getPage() : page;
		rows = rows == null ? pb.getRows() : rows;
		pb.setPage(page);
		pb.setRows(rows);
		// 获取当前页记录集合
		List<orderform> lsom = bizservice.getOrderformbiz().findall(pb);
		// 获取总记录数
		int maxrows = bizservice.getOrderformbiz().findmaxrows();
		System.out.println(maxrows);
		map.put("page", page);
		map.put("rows", lsom);
		map.put("total", maxrows);
		String josnstr = JSONObject.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect);
		AjAxUtils.printString(response, josnstr);
		return null;
	}
}
