package com.wjp.springframework.test;

import com.wjp.springframework.context.support.ClassPathXmlApplicationContext;
import com.wjp.springframework.test.bean.IUserService;
import com.wjp.springframework.test.event.CustomEvent;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

public class ApiTest {
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring2.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }


//    @Test
//    public void test_factory_bean() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring1.xml");
//        applicationContext.registerShutdownHook();
//
//        // 2. 调用代理方法
//        IUserService userService = applicationContext.getBean("userService", IUserService.class);
//        System.out.println("测试结果：" + userService.queryUserInfo());
//    }

    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring1.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        IUserService userService01 = applicationContext.getBean("userService", IUserService.class);
        IUserService userService02 = applicationContext.getBean("userService", IUserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());

    }


//    @Test
//    public void test_xml() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        applicationContext.registerShutdownHook();
//
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//        System.out.println("ApplicationContextAware：" + userService.getApplicationContext());
//        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
//    }


//    @Test
//    public void test_xml() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        applicationContext.registerShutdownHook();
//
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }

//    @Test
//    public void test_xml() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
//
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }


//    @Test
//    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. 读取配置文件&注册Bean
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions("classpath:spring.xml");
//
//        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
//        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
//        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
//
//        // 4. Bean实例化之后，修改 Bean 属性信息
//        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
//        beanFactory.addBeanPostProcessor(beanPostProcessor);
//
//        // 5. 获取Bean对象调用方法
//        UserService userService = beanFactory.getBean("userService", UserService.class);
//        String result = userService.queryUserInfo();
//        System.out.println("测试结果：" + result);
//    }


//    private DefaultResourceLoader resourceLoader;
//
//    @BeforeEach
//    public void init() {
//        resourceLoader = new DefaultResourceLoader();
//    }
//
//    @Test
//    public void test_classpath() throws IOException {
//        Resource resource = resourceLoader.getResource("classpath:important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }
//
//    @Test
//    public void test_file() throws IOException {
//        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }
//
//    @Test
//    public void test_url() throws IOException {
//        // 网络原因可能导致GitHub不能读取，可以放到自己的Gitee仓库。读取后可以从内容中搜索关键字；OLpj9823dZ
//        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/blob/main/important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }


//    @Test
//    void testBeanFactory() {
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//
//        // 2. 读取配置文件&注册Bean
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions("classpath:spring.xml");
//
//        Object userDao = factory.getBean("userDao");
//        System.out.println(userDao);
//        UserService userService = (UserService) factory.getBean("userService");
//        System.out.println(userService);
//        userService.test();
//    }
    //    第四次测试的代码
//    @Test
//    void testBeanFactory() {
//        // 1.创建bean工厂
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        // 2. 注入bean
//        // 2.1 userdao注册
//        PropertyValues propertyValues = new PropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("userId", 13));
//        propertyValues.addPropertyValue(new PropertyValue("name", "王景鹏"));
//        factory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class, propertyValues));
//        // 2.2 userService注册
//        PropertyValues values = new PropertyValues();
//        values.addPropertyValue(new PropertyValue("name", "王景鹏1111"));
//        values.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
//        factory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, values));
//        // 3.获取bean
//        Object userDao = factory.getBean("userDao");
//        System.out.println(userDao);
//        UserService userService = (UserService) factory.getBean("userService");
//        System.out.println(userService);
//        userService.test();
//    }


//    第一次的测试代码
//    @Test
//    void testBeanFactory() {
//        UserService service = new UserService("sdsa", 13, 669L);
//        BeanFactory beanFactory = new BeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition(service);
//        beanFactory.registerBeanDefinition("111", beanDefinition);
//        Object bean = beanFactory.getBean("111");
//        System.out.println(bean);
//    }

//    第二次测试的代码
    //    @Test
//    void testBeanFactory() throws BeansException {
//        // 1.创建bean工厂
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        // 2.创建beanDefinition
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        // 3.添加bean到bean工厂
//        factory.registryBeanDefinition("user", beanDefinition);
//        // 4。第一次获取bean
//        UserService user = (UserService) factory.getBean("user");
//        System.out.println(user);
//        user.test();
//
//        // 5.第二次获取bean
//        UserService user1 = (UserService) factory.getBean("user");
//        System.out.println(user1);
//        user1.test();
//    }

//    第三次测试的代码
//    @Test
//    public void test_BeanFactory() throws BeansException {
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        beanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());
//        // 2. 注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registryBeanDefinition("userService", beanDefinition);
//
//
//        // 3.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService", "孙卫国");
//        userService.test();
//        System.out.println(userService);
//    }
}
