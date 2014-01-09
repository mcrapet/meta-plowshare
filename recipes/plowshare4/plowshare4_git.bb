SUMMARY = "Plowshare is a set a tools for managing file sharing services"
DESCRIPTION = "Plowshare is a set of command-line bash scripts for \
managing downloads, uploads and remote folders from file hosting providers."
HOMEPAGE = "http://code.google.com/p/plowshare/"
BUGTRACKER = "http://code.google.com/p/plowshare/issues/list"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SECTION = "console/utils"

inherit allarch

SRC_URI = "git://code.google.com/p/plowshare.git;protocol=http;branch=master"
SRCREV = "${AUTOREV}"
PKGV = "${SRCPV}"

PR = "r7"

S = "${WORKDIR}/git"

do_compile[noexec] = "1"

do_install() {
	oe_runmake PREFIX="${prefix}" DESTDIR="${D}" install
	oe_runmake PREFIX="${prefix}" DESTDIR="${D}" install_bash_completion
}

RDEPENDS_${PN} = "bash sed curl"

PACKAGES =+ "${PN}-bash-completion"
FILES_${PN}-bash-completion = "${sysconfdir}/bash_completion.d/${BPN}"

ALLOW_EMPTY_${PN}-dev = "0"
ALLOW_EMPTY_${PN}-dbg = "0"
