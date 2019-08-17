package sm.trading.erp

import grails.persistence.Entity
import org.springframework.security.core.GrantedAuthority

@Entity
class Role implements GrantedAuthority{

    String authority
//    static belongsTo = [user: User]
    static mapping = {
        version false
//        user(cascade: 'all-delete-orphan')
    }
    static constraints = {
        authority unique: true, nullable: false
//        user nullable: true
    }

    Role(String authority) {
        this.authority = authority
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
