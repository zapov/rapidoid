package org.rapidoid.viewrendering;

/*
 * #%L
 * rapidoid-integration-tests
 * %%
 * Copyright (C) 2014 - 2016 Nikolche Mihajlovski and contributors
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

import org.junit.Test;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.http.IntegrationTestCommons;
import org.rapidoid.integrate.Integrate;
import org.rapidoid.setup.My;
import org.rapidoid.setup.On;
import org.rapidoid.u.U;

@Authors("Nikolche Mihajlovski")
@Since("5.2.0")
public class JMustacheViewRendererTest extends IntegrationTestCommons {

	@Test
	public void testRendering() {
		My.templatesPath("view-rendering");
		My.viewRenderer(Integrate.jMustacheViewRenderer());

		On.get("/").view("mtmpl").mvc((req, resp) -> {
			resp.model("y", "bar");
			return U.map("x", "foo");
		});

		getReq("/");
	}

}
