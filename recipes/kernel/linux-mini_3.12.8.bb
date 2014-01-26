SECTION = "kernel"
SUMMARY = "Small Linux kernel for x86_64 machines"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

PR = "r1"

COMPATIBLE_MACHINE = "generic-core2"

# Important: ${S} != ${B} is not supported here
S = "${WORKDIR}/linux"

SRC_URI = "ftp://www.kernel.org/pub/linux/kernel/v3.x/linux-${PV}.tar.xz \
           file://defconfig"

SRC_URI[md5sum] = "bacfc23a07a6fee0d271a4b062862445"
SRC_URI[sha256sum] = "b50b563b28e257e54336dadc7c8ca28f13df4416ffbed9b62489154c2ceb5597"

LINUX_VERSION_EXTENSION ?= "-m"

do_rename_shell() {
	cd ${WORKDIR}
	rm -rf ${S}
	mv 'linux-${PV}' '${S}'
}

do_unpack_append() {
    bb.build.exec_func('do_rename_shell', d)
}

do_configure_prepend() {
	echo '-----BEGIN OE CONFIG-----' > ${B}/.config

	echo 'CONFIG_LOCALVERSION="${LINUX_VERSION_EXTENSION}"' >> ${B}/.config
	echo '# CONFIG_LOCALVERSION_AUTO is not set' >> ${B}/.config

	echo '-----END OE CONFIG-----' >> ${B}/.config

	sed -e '/CONFIG_CMDLINE\(_BOOL\)\?=/d' \
		-e '/CONFIG_LOCALVERSION/d' \
		-e '/CONFIG_LOCALVERSION_AUTO/d' \
		< '${WORKDIR}/defconfig' >> ${B}/.config

	if [ "${S}" != "${B}" ]; then
		cp '${B}/.config' '${S}/.config'
		cd ${S}
	fi
}

do_bundle_initramfs() {
        :
}
do_bundle_initramfs[nostamp] = "1"
addtask bundle_initramfs after do_compile
