package tw.yung.rs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.req.Rsfc100Req;
import tw.yung.rs.controller.resp.Rsfc100Resp;
import tw.yung.rs.service.Rsfc100Service;
import tw.yung.rs.service.bo.Rsfc100Bo;

/**
 * <pre>
 * [Article修改經歷 Controller] Rsfc100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-13
 * @version 2021-08-13 崔永昀
 */
@RestController
@RequestMapping("/rsfc100")
public class Rsfc100Controller {
	private static final Logger logger = LoggerFactory.getLogger(Rsfc100Controller.class);

	@Autowired
	private Rsfc100Service rsfc100Service;

	@PostMapping(value = "/modifyExperience")
	public Rsfc100Resp modifyExperience(@RequestBody Rsfc100Req rsfc100Req) {
		Rsfc100Resp resp = new Rsfc100Resp();

		try {
			Rsfc100Bo bo = new Rsfc100Bo();
			BeanUtils.copyProperties(rsfc100Req, bo);
			resp = rsfc100Service.modifyExperience(bo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}
	
	@PostMapping(value = "/deleteExperience")
	public Rsfc100Resp deleteExperience(@RequestBody Rsfc100Req rsfc100Req) {
		Rsfc100Resp resp = new Rsfc100Resp();

		try {
			Rsfc100Bo bo = new Rsfc100Bo();
			BeanUtils.copyProperties(rsfc100Req, bo);
			resp = rsfc100Service.deleteExperience(bo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}
	
	@PostMapping(value = "/modifyProject")
	public Rsfc100Resp modifyProject(@RequestBody Rsfc100Req rsfc100Req) {
		Rsfc100Resp resp = new Rsfc100Resp();

		try {
			Rsfc100Bo bo = new Rsfc100Bo();
			BeanUtils.copyProperties(rsfc100Req, bo);
			resp = rsfc100Service.modifyProject(bo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}
	
	@PostMapping(value = "/deleteProject")
	public Rsfc100Resp deleteProject(@RequestBody Rsfc100Req rsfc100Req) {
		Rsfc100Resp resp = new Rsfc100Resp();

		try {
			Rsfc100Bo bo = new Rsfc100Bo();
			BeanUtils.copyProperties(rsfc100Req, bo);
			resp = rsfc100Service.deleteProject(bo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}
}
