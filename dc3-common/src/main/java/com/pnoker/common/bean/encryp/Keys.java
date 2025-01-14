/*
 * Copyright 2019 Pnoker. All Rights Reserved.
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
package com.pnoker.common.bean.encryp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>Copyright(c) 2019. Pnoker All Rights Reserved.
 * <p>Author     : Pnoker
 * <p>Email      : pnokers@gmail.com
 * <p>Description: AES & RSA 算法密钥实体类
 */
public class Keys {

    /**
     * RSA 密钥对
     */
    @Data
    @AllArgsConstructor
    public class Rsa {
        private String publicKey;
        private String privateKey;
    }

    /**
     * Aes 密钥
     */
    @Data
    @AllArgsConstructor
    public class Aes {
        private String privateKey;
    }
}
