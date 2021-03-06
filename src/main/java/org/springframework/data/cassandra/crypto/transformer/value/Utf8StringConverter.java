/*
 * Copyright 2014-2017 the original author or authors.
 *
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
 */
package org.springframework.data.cassandra.crypto.transformer.value;

import java.nio.charset.Charset;

public final class Utf8StringConverter implements BytesConverter<String> {
    public static final BytesConverter<String> INSTANCE = new Utf8StringConverter();
    static final String DEFAULT_CHARSET = "UTF-8";
    private final Charset utf8;

    Utf8StringConverter() {
        this.utf8 = Charset.forName(DEFAULT_CHARSET);
    }

    @Override
    public byte[] toBytes(String value) {
        return value.getBytes(utf8);
    }
    
    @Override
    public String fromBytes(byte[] bytes) {
        return new String(bytes, utf8);
    }

}
