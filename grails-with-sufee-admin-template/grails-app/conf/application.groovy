
// Added by the Spring Security Core plugin:
grails.assets.bundle=true
grails.plugin.springsecurity.logout.postOnly=false
grails.plugin.springsecurity.userLookup.userDomainClassName = 'sm.trading.erp.User'
//grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'sm.trading.erp.UserRole'
grails.plugin.springsecurity.authority.className = 'sm.trading.erp.Role'
grails.plugin.springsecurity.requestMap.className = 'sm.trading.erp.Requestmap'
//grails.plugin.springsecurity.securityConfigType = 'Requestmap'
grails.plugin.springsecurity.password.algorithm = 'bcrypt'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
//    [pattern: '/login/auth', access: ['ROLE_ANONYMOUS']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]