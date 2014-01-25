SUMMARY = "A console-only image for simply running plowshare."

IMAGE_FEATURES += "ssh-server-openssh debug-tweaks doc-pkgs"

PR = "r3"
LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL = "\
    plowshare4 plowshare4-bash-completion plowshare4-plugin-mega \
    kbd bash-completion \
    git \
    vim \
"

IMAGE_FSTYPES += "vmdk"

inherit core-image
