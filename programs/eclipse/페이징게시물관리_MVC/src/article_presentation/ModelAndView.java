package article_presentation;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class ModelAndView {

	String viewName;
	public HashMap<String, Object> attributes = new HashMap<String, Object>();

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public void addObject(String key, Object value) {

		attributes.put(key, value);

	}

}
