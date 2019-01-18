/*
 * Copyright 2005-2013 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.chinatour.service;


import com.chinatour.LogConfig;

import java.util.List;

/**
 * Service - 日志配置
 *
 * @author SHOP++ Team
 * @version 3.0
 */
public interface LogConfigService {

    /**
     * 获取所有日志配置
     *
     * @return 所有日志配置
     */
    List<LogConfig> getAll();

}