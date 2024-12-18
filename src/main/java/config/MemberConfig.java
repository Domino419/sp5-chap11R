package config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
@EnableTransactionManagement
public class MemberConfig {

    /**
     * method        : dataSource
     * date          : 24-12-04
     * return        : DataSource - 데이터베이스 연결을 관리하는 DataSource 객체
     * description   : MySQL 데이터베이스와 연결하기 위한 DataSource 설정.
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
       // ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
        ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8&useSSL=false&requireSSL=false");  // SSL을 사용하지 않도록 설정
        ds.setUsername("spring5");  //Db연결시 사용자명
        ds.setPassword("spring5");  // Db연결시 암호
        ds.setInitialSize(3);       // 커넥션 갯수
        ds.setMaxActive(10);        // 커넥션 풀에서 가져올 수 있는 커넥션 max개수
        ds.setTestWhileIdle(true);  // 유휴 커넥션 검사
        ds.setMinEvictableIdleTimeMillis(1000*60*3);  // 최소 유휴 시간 3분
        ds.setTimeBetweenEvictionRunsMillis(1000*10);  // 유휴 커넥션 검사 주기: 10초
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager() ;
        tm.setDataSource(dataSource());
        return tm ;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource()) ;
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService(memberDao()) ;
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService() ;
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc ;
    }

}
