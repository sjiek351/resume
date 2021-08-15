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
import tw.yung.rs.controller.req.Rsfb100Req;
import tw.yung.rs.controller.resp.Rsfb100Resp;
import tw.yung.rs.service.Rsfb100Service;
import tw.yung.rs.service.bo.Rsfb100Bo;

/**
 * <pre>
 * [Article修改技能 Controller] Rsfb100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-08
 * @version 2021-08-08 崔永昀
 */
@RestController
@RequestMapping("/rsfb100")
public class Rsfb100Controller {
	private static final Logger logger = LoggerFactory.getLogger(Rsfb100Controller.class);

	@Autowired
	private Rsfb100Service rsfb100Service;

	@PostMapping(value = "/modifySkill")
	public Rsfb100Resp modifySkill(@RequestBody Rsfb100Req rsfb100Req) {
		Rsfb100Resp resp = new Rsfb100Resp();

		try {
			Rsfb100Bo bo = new Rsfb100Bo();
			BeanUtils.copyProperties(rsfb100Req, bo);
			resp = rsfb100Service.modifySkill(bo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}
	
	@PostMapping(value = "/deleteSkill")
	public Rsfb100Resp deleteSkill(@RequestBody Rsfb100Req rsfb100Req) {
		Rsfb100Resp resp = new Rsfb100Resp();

		try {
			Rsfb100Bo bo = new Rsfb100Bo();
			BeanUtils.copyProperties(rsfb100Req, bo);
			resp = rsfb100Service.deleteSkill(bo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}
}
