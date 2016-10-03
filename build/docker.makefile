# usage: $(call build,$(host),$(image_name),$(version),$(working_dir))
#                     $(1)    $(2)          $(3)       $(4)
define build
	@printf "\n====================\n= Building $(2):$(3)\n====================\n"
	docker build --rm -t $(1)/$(2):$(3) $(4)
	docker tag $(1)/$(2):$(3) $(1)/$(2):latest
endef
