package tw.yung.rs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsza100Resp;
import tw.yung.rs.service.Rsza100Service;

/**
 * <pre>
 * [Footer Controller] Rsza100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-11
 * @version 2021-08-11 崔永昀
 */
@RestController
@RequestMapping("/rsza100")
public class Rsza100Controller {
	private static final Logger logger = LoggerFactory.getLogger(Rsza100Controller.class);

	@Autowired
	private Rsza100Service rsza100Service;

	@PostMapping(value = "/findPersonal")
	public Rsza100Resp findPersonal() {
		Rsza100Resp resp = new Rsza100Resp();

		try {
			resp = rsza100Service.findPersonal();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}

}
