package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
public class Security {
    private String username;
    private String password;
    private int failedLoginAttempts;
    private List<String> roles;
    private String accountCreationDate;

    protected Security() {
    }

    public Security(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.failedLoginAttempts = builder.failedLoginAttempts;
        this.accountCreationDate = builder.accountCreationDate;
        this.roles = builder.roles;
    }

    public Security(String username, String password) {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getAccountCreationDate() {
        return accountCreationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return failedLoginAttempts == security.failedLoginAttempts && Objects.equals(username, security.username) && Objects.equals(password, security.password) && Objects.equals(roles, security.roles) && Objects.equals(accountCreationDate, security.accountCreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, failedLoginAttempts, roles, accountCreationDate);
    }


    @Override
    public String toString() {
        return "Security{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", failedLoginAttempts=" + failedLoginAttempts +
                ", roles=" + roles +
                ", accountCreationDate=" + accountCreationDate +
                '}';
    }
    public static class Builder {
        private String username;
        private String password;
        private int failedLoginAttempts;
        private List<String> roles;
        private String accountCreationDate;

        public Builder setUsername(String username){
            this.username = username;
            return this;
        }
        public Builder setPassword(String Password){
            this.password = Password;
            return this;
        }
        public Builder setFailedLoginAttempts(int failedLoginAttempts){
            this.failedLoginAttempts = failedLoginAttempts;
            return this;
        }
        public Builder setRoles(List<String> roles){
            this.roles = roles;
            return this;
        }

        public Builder setAccountCreationDate(String accountCreationDate){
            this.accountCreationDate = accountCreationDate;
            return this;
        }
        public Builder copy(Security security){
            this.username = security.username;
            this.password = security.password;
            this.failedLoginAttempts = security.failedLoginAttempts;
            this.accountCreationDate = security.accountCreationDate;
            this.roles = security.roles;
            return this;
        }

        public Security build(){
            return new Security(this);
        }

    }
}




