package com.sso.ssoclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
public class UiWebConfig implements WebMvcConfigurer {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/")
//                .setViewName("forward:/login");
                .setViewName("/index");
        registry.addViewController("/index");
        registry.addViewController("/securedPage");
        registry.addViewController("/login1");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

//    @Configuration
//    @EnableOAuth2Client
//    public class Oauth2ClientConfig {
//
//        private String redirectUri = "http://localhost:8082/ui/index";
//        private String checkTokenUrl = "http://localhost:8081/auth/oauth/token_check";
//
//        @Bean
//        public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext context, OAuth2ProtectedResourceDetails details) {
//            OAuth2RestTemplate template = new OAuth2RestTemplate(details, context);
//
////            AuthorizationCodeAccessTokenProvider authCodeProvider = new AuthorizationCodeAccessTokenProvider();
////            authCodeProvider.setStateMandatory(false);
////            AccessTokenProviderChain provider = new AccessTokenProviderChain(
////                    Arrays.asList(authCodeProvider));
////            template.setAccessTokenProvider(provider);
//            template.setAccessTokenProvider(new AuthorizationCodeAccessTokenProvider());
//            return template;
//        }
//
//        /**
//         * 注册处理redirect uri的filter
//         *
//         * @param oauth2RestTemplate
//         * @param tokenService
//         * @return
//         */
//        @Bean
//        public OAuth2ClientAuthenticationProcessingFilter oauth2ClientAuthenticationProcessingFilter(
//                OAuth2RestTemplate oauth2RestTemplate)
////                RemoteTokenServices tokenService) {
//        {
//            OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(redirectUri);
//            filter.setRestTemplate(oauth2RestTemplate);
////            filter.setTokenServices(tokenService);
//
//
//            //设置回调成功的页面
//            filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler() {
//                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                    this.setDefaultTargetUrl("/index");
//                    super.onAuthenticationSuccess(request, response, authentication);
//                }
//            });
//            return filter;
//        }
//
//        /**
//         * 注册check token服务
//         * @param details
//         * @return
//         */
////        @Bean
////        public RemoteTokenServices tokenService(OAuth2ProtectedResourceDetails details) {
////            RemoteTokenServices tokenService = new RemoteTokenServices();
////            tokenService.setCheckTokenEndpointUrl(checkTokenUrl);
////            tokenService.setClientId(details.getClientId());
////            tokenService.setClientSecret(details.getClientSecret());
////            return tokenService;
////        }
//    }

}