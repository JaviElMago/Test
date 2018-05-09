package almundo.callcenter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import almundo.callcenter.business.Dispatcher;
import almundo.callcenter.datatransfer.InputDTO;
import almundo.callcenter.datatransfer.OutputDTO;
import almundo.callcenter.entity.Call;
import almundo.callcenter.entity.Employee;

@RestController
@RequestMapping("/call")
public class DispatcherController {
	
	@Autowired
	private Dispatcher dispatcher;
	
	/**
	 * Service to process a call
	 * @param call
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@RequestMapping(value = "/process", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public OutputDTO process(InputDTO call) throws InterruptedException, ExecutionException{
		return dispatcher.processCall(call);
	}

}
