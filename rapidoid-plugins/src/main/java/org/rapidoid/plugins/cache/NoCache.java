package org.rapidoid.plugins.cache;

/*
 * #%L
 * rapidoid-plugins
 * %%
 * Copyright (C) 2014 - 2015 Nikolche Mihajlovski and contributors
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

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.concurrent.Callback;
import org.rapidoid.concurrent.Callbacks;

@Authors("Nikolche Mihajlovski")
@Since("4.1.0")
public class NoCache<K, V> extends AbstractCache<K, V> {

	public NoCache(String cacheName, long timeToLiveMs, boolean resetTimeToLiveWhenAccessed) {
		super(cacheName, timeToLiveMs, true);
	}

	@Override
	protected void doSet(K key, V value, long timeToLiveMs, Callback<Void> callback) {
		Callbacks.success(callback, null);
	}

	@Override
	protected void doGet(K key, Callback<V> callback) {
		Callbacks.success(callback, null);
	}

}
