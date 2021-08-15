package tw.yung.rs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsea100Resp;
import tw.yung.rs.service.Rsea100Service;

/**
 * <pre>
 * [Article關於我 Controller] Rsea100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-06
 * @version 2021-08-06 崔永昀
 */
@RestController
@RequestMapping("/rsea100")
public class Rsea100Controller {
	private static final Logger logger = LoggerFactory.getLogger(Rsea100Controller.class);

	@Autowired
	private Rsea100Service rsea100Service;

	@PostMapping(value = "/findPersonal")
	public Rsea100Resp findPersonal() {
		Rsea100Resp resp = new Rsea100Resp();

		try {
			resp = rsea100Service.findPersonal();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}

}
