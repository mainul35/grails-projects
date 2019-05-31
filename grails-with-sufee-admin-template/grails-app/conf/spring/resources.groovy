
import sm.trading.erp.CustomAuthentication
import sm.trading.erp.CustomUserDetailsService
import sm.trading.erp.UserPasswordEncoderListener
import sm.trading.erp.UserService

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    userDetailsService(CustomUserDetailsService)
    customAuthentication(CustomAuthentication)
    userService(UserService)
}
