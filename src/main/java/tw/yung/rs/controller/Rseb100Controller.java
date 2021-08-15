package tw.yung.rs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rseb100Resp;
import tw.yung.rs.service.Rseb100Service;

/**
 * <pre>
 * [Article技能 Controller] Rseb100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-07
 * @version 2021-08-07 崔永昀
 */
@RestController
@RequestMapping("/rseb100")
public class Rseb100Controller {
	private static final Logger logger = LoggerFactory.getLogger(Rseb100Controller.class);

	@Autowired
	private Rseb100Service rseb100Service;

	@PostMapping(value = "/findSkills")
	public Rseb100Resp findSkills() {
		Rseb100Resp resp = new Rseb100Resp();

		try {
			resp = rseb100Service.findSkills();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}

}
