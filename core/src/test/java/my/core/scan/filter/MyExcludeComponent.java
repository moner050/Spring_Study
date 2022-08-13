package my.core.scan.filter;

import java.lang.annotation.*;

// ComponentScan 에서 제외할 어노테이션
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}
