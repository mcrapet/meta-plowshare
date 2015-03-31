SUMMARY = "Legacy & unmaintained modules for Plowshare"
HOMEPAGE = "https://github.com/mcrapet/plowshare-modules-legacy"

SECTION = "console/utils"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

inherit allarch

SRC_URI = "git://github.com/mcrapet/plowshare-modules-legacy.git"
SRCREV = "${AUTOREV}"
PV = "1+git${SRCPV}"
S = "${WORKDIR}/git"

do_compile[noexec] = "1"

FILES_${PN} += "${datadir}/plowshare/modules/*.sh \
    ${datadir}/plowshare/modules/config.* \
"

do_install() {
	local o=${D}${datadir}/plowshare/modules
	install -d $o
	install -m 0755 ${S}/*.sh $o
	cp ${S}/config $o/config.unmaintained
}

RDEPENDS_${PN} = "plowshare"

pkg_postinst_${PN} () {
	conf1="$D${datadir}/plowshare/modules/config"
	conf2="$D${datadir}/plowshare/modules/config.unmaintained"
	cat $conf2 >> $conf1
	sort -uo $conf1 $conf1
}

# FIXME: substract config.unmaintained from config
#pkg_postrm_${PN} () {
#}
