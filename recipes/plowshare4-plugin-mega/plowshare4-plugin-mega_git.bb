SUMMARY = "mega.co.nz plugin for Plowshare4"
HOMEPAGE = "http://code.google.com/p/plowshare/"
BUGTRACKER = "http://code.google.com/p/plowshare/issues/list"

SECTION = "console/utils"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "openssl"

PR = "r5"

SRC_URI = "git://code.google.com/p/plowshare.plugin-mega.git;protocol=http;branch=master"
SRCREV = "${AUTOREV}"
PV = "1+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
	oe_runmake PREFIX="${prefix}" DESTDIR="${D}" install
}

RDEPENDS_${PN} = "plowshare4"

FILES_${PN} += "${datadir}/plowshare4/modules/mega.sh \
                ${datadir}/plowshare4/plugins/mega"
FILES_${PN}-dbg += "${datadir}/plowshare4/plugins/.debug"

pkg_postinst_${PN} () {
	conf="$D${datadir}/plowshare4/modules/config"
	grep -q '^mega[[:space:]]' $conf || \
		echo 'mega            | download | upload |        |      | probe |' >> $conf
}

pkg_postrm_${PN} () {
	conf="$D${datadir}/plowshare4/modules/config"
	grep -q '^mega[[:space:]]' $conf && \
		sed -i -e '/^mega[[:space:]]/d' $conf || true
}
