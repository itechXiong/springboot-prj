package com.xitech.app.framework.common.interceptor;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
@Component
@Intercepts(@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }))
public class PaginationInterceptor implements Interceptor {

	 public Object intercept(Invocation invocation) throws Throwable {

		 	
	        System.out.println("dddddddddddddddddddddddddd");
	        return invocation.proceed();
	    }


	    public Object plugin(Object target) {
	        return Plugin.wrap(target, this);
	    }

	    public void setProperties(Properties properties) {
	    }


}
