DESCRIPTION = "A console-only image for simply running plowshare."

# (no root password)
IMAGE_FEATURES += "ssh-server-openssh debug-tweaks"

PR = "r1"
LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL = "\
    kbd \
    plowshare4 \
    plowshare4-bash-completion \
    plowshare4-plugin-mega \
    git \
    vim \
"

IMAGE_FSTYPES += "vmdk"

inherit core-image
