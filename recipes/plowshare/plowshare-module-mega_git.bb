SUMMARY = "mega.co.nz module for Plowshare"
HOMEPAGE = "http://code.google.com/p/plowshare/"
BUGTRACKER = "http://code.google.com/p/plowshare/issues/list"

SECTION = "console/utils"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "openssl"

SRC_URI = "git://code.google.com/p/plowshare.module-mega.git;protocol=http;branch=master"
SRCREV = "${AUTOREV}"
PV = "1+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
	oe_runmake PREFIX="${prefix}" DESTDIR="${D}" install
}

RDEPENDS_${PN} = "plowshare"

FILES_${PN} += "${datadir}/plowshare/modules/mega.sh \
                ${datadir}/plowshare/exec/mega"
FILES_${PN}-dbg += "${datadir}/plowshare/exec/.debug"

pkg_postinst_${PN} () {
	conf="$D${datadir}/plowshare/modules/config"
	grep -q '^mega[[:space:]]' $conf || \
		echo 'mega            | download | upload |        |      | probe |' >> $conf
}

pkg_postrm_${PN} () {
	conf="$D${datadir}/plowshare/modules/config"
	grep -q '^mega[[:space:]]' $conf && \
		sed -i -e '/^mega[[:space:]]/d' $conf || true
}
