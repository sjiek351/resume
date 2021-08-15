package tw.yung.rs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.yung.framework.constant.Message;
import tw.yung.rs.controller.resp.Rsec100Resp;
import tw.yung.rs.service.Rsec100Service;

/**
 * <pre>
 * [Article經歷 Controller] Rsec100
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-14
 * @version 2021-08-14 崔永昀
 */
@RestController
@RequestMapping("/rsec100")
public class Rsec100Controller {
	private static final Logger logger = LoggerFactory.getLogger(Rsec100Controller.class);

	@Autowired
	private Rsec100Service rsec100Service;

	@PostMapping(value = "/findExps")
	public Rsec100Resp findExps() {
		Rsec100Resp resp = new Rsec100Resp();

		try {
			resp = rsec100Service.findExps();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resp.setMessage(Message.E001);
		}

		return resp;
	}

}
