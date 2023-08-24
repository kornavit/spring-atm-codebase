package atm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMConfig {
    @Bean
    public DataSource dataSource() { // interface or superclass the first the use in other bean
        return new DataSourceDB();
    }
    @Bean
    public Bank bank(DataSource dataSource) { // use the upon Bean DataSource line 10
        return new Bank("KU Bank", dataSource);
    }
    @Bean
    public ATM atm(Bank bank) {
        return new ATM(bank);
    }
    @Bean
    public AtmUI atmUI(ATM atm) {
        return new AtmUI(atm);
    }
}

