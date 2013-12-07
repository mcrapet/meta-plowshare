DESCRIPTION = "A console-only image for simply running plowshare."

IMAGE_FEATURES += "ssh-server-openssh debug-tweaks"

PR = "r1"
LICENSE = "MIT"

IMAGE_LINGUAS = ""

CORE_IMAGE_EXTRA_INSTALL = "\
    plowshare4 \
    plowshare4-bash-completion \
    plowshare4-plugin-mega \
    git \
    vim \
"

IMAGE_FSTYPES += "vmdk"

inherit core-image
