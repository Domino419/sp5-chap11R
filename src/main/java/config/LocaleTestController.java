//package config;
//
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.Locale;
//
//@RestController
//public class LocaleTestController {
//
//    @GetMapping("/current-locale")
//    public String currentLocale() {
//        Locale locale = LocaleContextHolder.getLocale();
//        return "Current Locale: " + locale;
//    }
//}