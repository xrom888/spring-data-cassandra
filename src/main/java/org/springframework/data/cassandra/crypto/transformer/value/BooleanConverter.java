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

/**
 * Converts between java.util.Date and byte[], based on the long timestamp encoding.
 */
public class BooleanConverter implements BytesConverter<Boolean> {
    public static final BytesConverter<Boolean> INSTANCE = new BooleanConverter();

    @Override
    public Boolean fromBytes(byte[] bytes) {
        if (bytes.length != 1) {
            throw new IllegalArgumentException("Unexpected number of bytes for boolean: " + bytes.length);
        }

        final byte b = bytes[0];
        if (b == 0) {
            return Boolean.FALSE;
        } else if (b == 1) {
            return Boolean.TRUE;
        } else {
            throw new IllegalArgumentException("Unexpected byte columnCryptoState for boolean: " + b);
        }
    }

    @Override
    public byte[] toBytes(Boolean value) {
        return new byte[] {
                value ? (byte) 1 : 0
        };
    }
}
