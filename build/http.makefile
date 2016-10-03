# $(call test-http,http://myurl/status,200,$@)
define test-http
	@echo $(3): $(1)
	$(eval return := $(shell curl -k -s -o /dev/null -w "%{http_code}" $(1)))
	@printf "\tServer returned $(return)\n"
	@[ $(return) -eq $(2) ]
endef
