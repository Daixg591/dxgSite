package com.shahenpc.framework.config;

import com.shahenpc.common.utils.SecurityUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 自定义身份校验
 * @author  hardy
 * 2022-08-23
 */
public class CustomLoginAuthenticationProvider extends DaoAuthenticationProvider {
    public CustomLoginAuthenticationProvider(UserDetailsService userDetailsService) {
        super();
        setUserDetailsService(userDetailsService);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) {
        if (authentication.getCredentials() == null) {
            this.logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        } else {
            String presentedPassword = authentication.getCredentials().toString();
            if ("CUSTOM_LOGIN_SMS".equals(presentedPassword)) {
                //短信登录，不验证密码（还可以继续扩展，只要传进来的password标识即可）
            } else {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String aa = userDetails.getPassword();
                if (!matches(presentedPassword, userDetails.getPassword())) {
                    this.logger.debug("Authentication failed: password does not match stored value");
                    throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
                }
            }
        }
    }


    /**
     *
     * @param rawPassword  原始密码
     * @param encodedPassword   加密后密码
     * @return
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        } else if (encodedPassword != null && encodedPassword.length() != 0) {
            return SecurityUtils.encryptPassword(rawPassword).equals(encodedPassword);
        } else {
            this.logger.warn("Empty encoded password");
            return false;
        }
    }
}
