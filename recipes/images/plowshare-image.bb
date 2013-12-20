DESCRIPTION = "A console-only image for simply running plowshare."

# (no root password)
IMAGE_FEATURES += "ssh-server-openssh debug-tweaks"

PR = "r2"
LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL = "\
    plowshare4 plowshare4-doc plowshare4-bash-completion plowshare4-plugin-mega \
    kbd \
    git \
    vim \
"

IMAGE_FSTYPES += "vmdk"

inherit core-image
