package ch29.a;

import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages= {"ch29.a","ch29.j"}) // 둘 이상의 패키지를 선택할 때
@ComponentScan(basePackages= "ch29.a")
public class AppConfig03 {
}
