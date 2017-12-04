/*-
 * #%L
 * rapidoid-web
 * %%
 * Copyright (C) 2014 - 2017 Nikolche Mihajlovski and contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.rapidoid.web;


import org.rapidoid.AbstractRapidoidModule;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.RapidoidModuleDesc;
import org.rapidoid.annotation.Since;
import org.rapidoid.config.Conf;
import org.rapidoid.web.config.listener.APIConfigListener;
import org.rapidoid.web.config.listener.PagesConfigListener;
import org.rapidoid.web.config.listener.ProxyConfigListener;

@Authors("Nikolche Mihajlovski")
@Since("5.3.0")
@RapidoidModuleDesc(name = "Web", order = 10000)
public class WebModule extends AbstractRapidoidModule {

	private static final ProxyConfigListener PROXY_CONFIG_LISTENER = new ProxyConfigListener();
	private static final APIConfigListener API_CONFIG_LISTENER = new APIConfigListener();
	private static final PagesConfigListener PAGES_CONFIG_LISTENER = new PagesConfigListener();

	@Override
	public void boot() {
		Conf.PROXY.addChangeListener(PROXY_CONFIG_LISTENER);
		Conf.API.addChangeListener(API_CONFIG_LISTENER);
		Conf.PAGES.addChangeListener(PAGES_CONFIG_LISTENER);
	}

	@Override
	public void cleanUp() {
		Conf.PROXY.removeChangeListener(PROXY_CONFIG_LISTENER);
		Conf.PROXY.removeChangeListener(API_CONFIG_LISTENER);
		Conf.PROXY.removeChangeListener(PAGES_CONFIG_LISTENER);
	}

}
