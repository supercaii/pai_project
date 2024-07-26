package com.github.paicoding.forum.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.paicoding.forum.core.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.standard.serializer.IStandardJavaScriptSerializer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

/**
 * 注册xml解析器
 *
 * @author yihui
 * @date 2022/6/20
 */
@Slf4j
@Configuration
public class PaiWebConfig implements WebMvcConfigurer {
    @Resource
    private TemplateEngine templateEngine;

    @PostConstruct
    private void init() {
        log.info("PaiWebConfig init...");
        // 通过templateEngine获取SpringStandardDialect
        SpringStandardDialect springStandardDialect = CollectionUtils.findValueOfType(templateEngine.getDialects(), SpringStandardDialect.class);
        IStandardJavaScriptSerializer standardJavaScriptSerializer = springStandardDialect.getJavaScriptSerializer();
        // 反射获取 IStandardJavaScriptSerializer
        Field delegateField = ReflectionUtils.findField(standardJavaScriptSerializer.getClass(), "delegate");
        if (delegateField == null) {
            log.warn("WebConfig init, failed set jackson module, delegateField is null");
            return;
        }
        ReflectionUtils.makeAccessible(delegateField);
        Object delegate = ReflectionUtils.getField(delegateField, standardJavaScriptSerializer);
        if (delegate == null) {
            log.warn("WebConfig init, failed set jackson module, delegateField is null");
            return;
        }
        // 如果代理类是JacksonStandardJavaScriptSerializer,则获取mapper,设置model
        if (Objects.equals("JacksonStandardJavaScriptSerializer", delegate.getClass().getSimpleName())) {
            Field mapperField = ReflectionUtils.findField(delegate.getClass(), "mapper");
            if (mapperField == null) {
                log.warn("WebConfig init, failed set jackson module, mapperField is null");
                return;
            }
            ReflectionUtils.makeAccessible(mapperField);
            ObjectMapper objectMapper = (ObjectMapper) ReflectionUtils.getField(mapperField, delegate);
            if (objectMapper == null) {
                log.warn("WebConfig init, filed set jackson module, mapper is null");
                return;
            }
            // 设置序列化Module,修改long型序列化为字符串
            objectMapper.registerModule(JsonUtil.bigIntToStrsimpleModule());
            log.info("WebConfig init 设置jackson序列化long为字符串成功!!!");
        }
    }

    /**
     * 配置序列化方式
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2XmlHttpMessageConverter());
        converters.forEach(s -> {
            if (s instanceof MappingJackson2HttpMessageConverter) {
                // 长整型序列化返回时，更新为string，避免前端js精度丢失
                // 注意这个仅适用于json数据格式的返回，对于Thymeleaf的模板渲染依然会出现精度问题
                ((MappingJackson2HttpMessageConverter) s).getObjectMapper().registerModule(JsonUtil.bigIntToStrsimpleModule());
            }
        });
    }

    /**
     * fixme 返回数据类型的配置, 相关知识点可以查看  <a href="https://spring.hhui.top/spring-blog/2022/08/17/220817-SpringBoot%E7%B3%BB%E5%88%97%E4%B9%8B%E5%AE%9A%E4%B9%89%E6%8E%A5%E5%8F%A3%E8%BF%94%E5%9B%9E%E7%B1%BB%E5%9E%8B%E7%9A%84%E5%87%A0%E7%A7%8D%E6%96%B9%E5%BC%8F/"/>
     *
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .defaultContentType(MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN, MediaType.TEXT_EVENT_STREAM, MediaType.APPLICATION_OCTET_STREAM, MediaType.MULTIPART_FORM_DATA, MediaType.MULTIPART_MIXED, MediaType.MULTIPART_RELATED)
                // 当下面的配置为false（默认值）时，通过浏览器访问后端接口，会根据acceptHeader协商进行返回，返回结果都是xml格式；与我们日常习惯不太匹配
                // 因此禁用请求头的AcceptHeader，在需要进行xml交互的接口上，手动加上 consumer, produces 属性； 因为本项目中，只有微信的交互是采用的xml进行传参、返回，其他的是通过json进行交互，所以只在微信的 WxRestController 中需要特殊处理；其他的默认即可
                .ignoreAcceptHeader(true)
                .parameterName("mediaType")
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("html", MediaType.TEXT_HTML)
                .mediaType("text", MediaType.TEXT_PLAIN)
                .mediaType("text/event-stream", MediaType.TEXT_EVENT_STREAM)
                .mediaType("application/octet-stream", MediaType.APPLICATION_OCTET_STREAM)
                .mediaType("multipart/form-data", MediaType.MULTIPART_FORM_DATA)
        ;
    }
}
