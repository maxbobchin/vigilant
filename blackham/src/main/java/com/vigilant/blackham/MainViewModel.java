package com.vigilant.blackham;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
//import org.zkoss.zss.ui.Spreadsheet;


public class MainViewModel {
	public static Logger logger = LoggerFactory.getLogger("blackham.vigilant");
	private int count;	
	
	private String workspacePage = WORKSPACE;
	private final static String WORKSPACE = "workspace.zul";

	@Init
	public void init() {
		logger.trace("MainViewModel.init");
		count = 100;
//		Spreadsheet a = null;
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	public int getCount() {
		return count;
	}
	
	@Command
	@NotifyChange({"workspacePage"})
	public void changePage(@BindingParam("page")String src){
		logger.info("Setting workspace src to " + src);
		setWorkspacePage(src);
	}
	
	public String getWorkspacePage() {
		return workspacePage;
	}

	public void setWorkspacePage(String workspacePage) {
		this.workspacePage = workspacePage;
	}

	@GlobalCommand
	public void logout() {
//		AuthenticationService.logout();
		Executions.sendRedirect("/");
	}
}
