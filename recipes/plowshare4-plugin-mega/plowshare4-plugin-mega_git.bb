SUMMARY = "mega.co.nz plugin for Plowshare4"
HOMEPAGE = "http://code.google.com/p/plowshare/"
BUGTRACKER = "http://code.google.com/p/plowshare/issues/list"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SECTION = "console/utils"
DEPENDS = "openssl"

inherit gitpkgv

SRC_URI = "git://code.google.com/p/plowshare.plugin-mega.git;protocol=http;branch=master"
SRCREV = "${AUTOREV}"
PKGV = "${SRCPV}"

PR = "r4"

S = "${WORKDIR}/git"

do_install() {
	oe_runmake PREFIX="${prefix}" DESTDIR="${D}" install
}

RDEPENDS_${PN} = "plowshare4"

FILES_${PN} += "${datadir}/plowshare4/modules/mega.sh \
                ${datadir}/plowshare4/plugins/mega"
FILES_${PN}-dbg += "${datadir}/plowshare4/plugins/.debug"
