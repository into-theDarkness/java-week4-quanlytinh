package tranminhduc.pro;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Applicationlnitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[]getRootConfigClasses(){
        return new Class[]{ApplicationConfig.class};
    }
    protected Class<?>[]getServletConfigClasses(){
        return new Class[0];
    }
    protected String[]getServletMappings(){
        return new String[]{"/"};
    }

}
