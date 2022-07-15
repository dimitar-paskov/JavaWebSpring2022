/**
 * @author dimitar
 *
 */
package bg.softuni.pathfinder.interceptors;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class IpBlackListInterceptor implements HandlerInterceptor {
	
	private List<String> blacklistedIpAddresses = new ArrayList<>();
	
	public IpBlackListInterceptor() {
		this.blacklistedIpAddresses.add("127.0.0.1");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String ipAddress = request.getRemoteAddr();
		
		System.out.println(ipAddress);
		
		if(blacklistedIpAddresses.contains(ipAddress)) {
			 
			response.sendRedirect("/error");
		}
		
		
		return true; 
	}

}
