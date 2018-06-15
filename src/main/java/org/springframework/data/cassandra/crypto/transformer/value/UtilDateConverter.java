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

import java.util.Date;
import java.util.Objects;

/**
 * Converts between java.util.Date and byte[], based on the long timestamp encoding.
 */
public class UtilDateConverter implements BytesConverter<Date> {
    public static final BytesConverter<Date> INSTANCE = new UtilDateConverter(LongConverter.INSTANCE);
    private final BytesConverter<Long> longConverter;

    public UtilDateConverter(BytesConverter<Long> longConverter) {
        this.longConverter = Objects.requireNonNull(longConverter);
    }

    @Override
    public Date fromBytes(byte[] bytes) {
        return new Date(longConverter.fromBytes(bytes));
    }

    @Override
    public byte[] toBytes(Date value) {
        return longConverter.toBytes(value.getTime());
    }
}