package com.apitest.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class ApiKeyConfiguration {
    // 금융 API 관련
    public static final String FIN_KEY = "f9badaa950efc0529842743233f57538";

    public static final String FIN_BASE = "http://finlife.fss.or.kr/finlifeapi/savingProductsSearch.json";


}
