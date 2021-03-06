/*
 * Copyright 2006 The Apache Software Foundation.
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
package com.cral;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * 
 */
@Conversion()
public class IndexAction extends ActionSupport implements SessionAware {


    private Map<String,Object> session;
    private Date now = new Date(System.currentTimeMillis());
    
    @TypeConversion(converter = "com.cral.DateConverter")
    public Date getDateNow() { return now; }


    public String execute() throws Exception {
        now = new Date(System.currentTimeMillis());
        session.put("aSessionKeyExample","aSessionValueExample");
        ServletActionContext.getRequest().getSession();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session = map;
    }
}
