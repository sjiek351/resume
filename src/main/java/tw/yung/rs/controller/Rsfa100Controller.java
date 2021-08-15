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
import tw.yung.rs.controller.req.Rsfa100Req;
import tw.yung.rs.controller.resp.Rsfa100Resp;
import tw.yung.rs.service.Rsfa100Service;
import tw.yung.rs.service.bo.Rsfa100Bo;

/**
 * <pre>
 * [Article修改關於我 Controller] Rsfa100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-08
 * @version 2021-08-08 崔永昀
 */
@RestController
@RequestMapping("/rsfa100")
public class Rsfa100Controller {
	private static final Logger logger = LoggerFactory.getLogger(Rsfa100Controller.class);

	@Autowired
	private Rsfa100Service rsfa100Service;

	@PostMapping(value = "/findPersonal")
	public Rsfa100Resp findPersonal(@RequestBody Rsfa100Req rsfa100Req) {
		Rsfa100Resp resp = new Rsfa100Resp();

		try {
			Rsfa100Bo bo = new Rsfa100Bo();
			BeanUtils.copyProperties(rsfa100Req, bo);
			resp = rsfa100Service.findPersonal(bo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}

	@PostMapping(value = "/modifyPersonal")
	public Rsfa100Resp modifyPersonal(@RequestBody Rsfa100Req rsfa100Req) {
		Rsfa100Resp resp = new Rsfa100Resp();

		try {
			Rsfa100Bo bo = new Rsfa100Bo();
			BeanUtils.copyProperties(rsfa100Req, bo);
			resp = rsfa100Service.modifyPersonal(bo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			resp.setMessage(Message.E001);
		}

		return resp;
	}

}
