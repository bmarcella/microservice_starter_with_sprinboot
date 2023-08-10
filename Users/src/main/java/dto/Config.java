package dto;

import java.util.List;
import java.util.Map;

import com.monkata.users.services.UserServiceConfig;

import lombok.Data;

@Data
public class Config {
	
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;
	public void setConfig(UserServiceConfig config) {
		msg = config.getMsg();
		buildVersion = config.getBuildVersion();
		mailDetails = config.getMailDetails();
		activeBranches =config.getActiveBranches();
	}

}
