SUMMARY = "Plowshare is a set a tools for managing file sharing services"
DESCRIPTION = "Plowshare is a set of command-line bash scripts for \
managing downloads, uploads and remote folders from file hosting providers."
HOMEPAGE = "https://github.com/mcrapet/plowshare"

SECTION = "console/utils"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit allarch

SRC_URI = "git://github.com/mcrapet/plowshare.git"
SRCREV = "${AUTOREV}"
PV = "1+git${SRCPV}"
S = "${WORKDIR}/git"

do_compile[noexec] = "1"

do_install() {
	oe_runmake PREFIX="${prefix}" DESTDIR="${D}" install
}

RDEPENDS_${PN} = "bash sed curl util-linux"

PACKAGES =+ "${PN}-bash-completion"
FILES_${PN}-bash-completion = "${datadir}/bash-completion/completions/plow*"

ALLOW_EMPTY_${PN}-dev = "0"
ALLOW_EMPTY_${PN}-dbg = "0"
