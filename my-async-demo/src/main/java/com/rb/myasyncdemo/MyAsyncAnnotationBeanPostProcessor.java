package com.rb.myasyncdemo;

import java.lang.annotation.Annotation;
import java.util.concurrent.Executor;
import java.util.function.Supplier;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AnnotationAsyncExecutionInterceptor;

public class MyAsyncAnnotationBeanPostProcessor extends AbstractBeanFactoryAwareAdvisingPostProcessor {
    public static final String DEFAULT_TASK_EXECUTOR_BEAN_NAME =
            AnnotationAsyncExecutionInterceptor.DEFAULT_TASK_EXECUTOR_BEAN_NAME;

    protected final Log logger = LogFactory.getLog(getClass());

    @Nullable
    private Supplier<Executor> executor;

    @Nullable
    private Supplier<AsyncUncaughtExceptionHandler> exceptionHandler;

    @Nullable
    private Class<? extends Annotation> asyncAnnotationType;

    public MyAsyncAnnotationBeanPostProcessor() {
        setBeforeExistingAdvisors(true);
    }

    public void configure(
            @Nullable Supplier<Executor> executor, @Nullable Supplier<AsyncUncaughtExceptionHandler> exceptionHandler) {

        this.executor = executor;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void setBeanFactory(final BeanFactory beanFactory) {
        super.setBeanFactory(beanFactory);

    }
}
