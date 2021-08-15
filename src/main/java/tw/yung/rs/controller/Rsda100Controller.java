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
import tw.yung.rs.controller.req.Rsda100Req;
import tw.yung.rs.controller.resp.Rsda100Resp;
import tw.yung.rs.service.Rsda100Service;
import tw.yung.rs.service.bo.Rsda100Bo;

/**
 * <pre>
 * [管理版面 Controller] Rsda100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-10
 * @version 2021-08-10 崔永昀
 */
@RestController
@RequestMapping("/rsda100")
public class Rsda100Controller {
	private static final Logger logger = LoggerFactory.getLogger(Rsda100Controller.class);

	@Autowired
	private Rsda100Service rsda100Service;

	@PostMapping(value = "/findPersonal")
	public Rsda100Resp findPersonal(@RequestBody Rsda100Req rsda100Req) {
		Rsda100Resp resp = new Rsda100Resp();

		try {
			Rsda100Bo bo = new Rsda100Bo();
			BeanUtils.copyProperties(rsda100Req, bo);
			resp = rsda100Service.findPersonal(bo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}

}
