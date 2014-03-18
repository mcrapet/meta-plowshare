SUMMARY = "A console-only image for simply running plowshare"

IMAGE_FEATURES += "ssh-server-openssh debug-tweaks doc-pkgs package-management"

PR = "r7"
LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL = "\
    plowshare4 plowshare4-bash-completion plowshare4-plugin-mega \
    bash-completion bash-completion-extra \
    kbd kbd-consolefonts kbd-keymaps \
    ${FRAMEBUFFER_PACKAGES} \
    git vim openssh screen man mc \
    kernel-modules \
"

FRAMEBUFFER_PACKAGES = "\
    fbida fim \
"

RDEPENDS = "\
    git vim openssh screen man mc \
    kernel-modules \
"

IMAGE_FSTYPES += "vmdk"

inherit core-image

# Image size will be 1Go
IMAGE_ROOTFS_EXTRA_SPACE_generic-core2 = "1048576"
IMAGE_DEVICE_TABLES_generic-core2 = ""
SYSLINUX_ROOT_generic-core2 = "vga=795 root=/dev/sda2 rw"
