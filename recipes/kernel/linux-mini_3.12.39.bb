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

SRC_URI[md5sum] = "9e59b7ea9501ac5ab4d4a3df5533ed37"
SRC_URI[sha256sum] = "866eadca255a56ba822aef23a3c749c6b9c9c977bb345c76b6f5fe3c6d166d6b"

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
