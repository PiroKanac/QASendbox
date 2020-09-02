package org.example.web;

import org.fluentlenium.core.annotation.PageUrl;

@PageUrl("/")
public class QASandboxPortal extends AbstractPortal {
	@Override
	public String getUrl() {
		return getConfiguration().getCustomProperty("BaseUrl");
	}

}
