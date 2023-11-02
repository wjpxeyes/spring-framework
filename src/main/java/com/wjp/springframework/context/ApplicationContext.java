package com.wjp.springframework.context;

import com.wjp.springframework.beans.factory.HierarchicalBeanFactory;
import com.wjp.springframework.beans.factory.ListableBeanFactory;
import com.wjp.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
