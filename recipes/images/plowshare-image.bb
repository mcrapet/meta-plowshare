SUMMARY = "A console-only image for simply running plowshare."

IMAGE_FEATURES += "ssh-server-openssh debug-tweaks doc-pkgs"

PR = "r4"
LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL = "\
    plowshare4 plowshare4-bash-completion plowshare4-plugin-mega \
    kbd bash-completion \
    git \
    vim screen \
"

IMAGE_FSTYPES += "vmdk"

inherit core-image

IMAGE_ROOTFS_EXTRA_SPACE_generic-core2 = "4096"
SYSLINUX_ROOT_generic-core2 = "vga=795 root=/dev/sda2 rw"
