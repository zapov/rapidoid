/*-
 * #%L
 * rapidoid-integration-tests
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

package org.rapidoid.http;


import org.junit.Test;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.setup.On;

@Authors("Nikolche Mihajlovski")
@Since("5.3.0")
public class HttpJsonStringTest extends IsolatedIntegrationTest {

	@Test
	public void testWithHandlerException() {
		String list = "[\"a\", 123, true]";

		On.get("/implicit-result").json((req, resp) -> list);

		On.get("/explicit-result").json((req, resp) -> resp.result(list));

		On.get("/explicit-body").json((req, resp) -> resp.body(list.getBytes()));

		onlyGet("/implicit-result");
		onlyGet("/explicit-result");
		onlyGet("/explicit-body");
	}

}
