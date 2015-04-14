SUMMARY = "A console-only image for simply running plowshare"

IMAGE_FEATURES += "ssh-server-openssh debug-tweaks doc-pkgs package-management"

LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL = "\
    plowshare plowshare-bash-completion plowshare-module-mega \
    bash-completion bash-completion-extra \
    kbd kbd-consolefonts kbd-keymaps \
    ${FRAMEBUFFER_PACKAGES} \
    git vim openssh screen man mc \
    kernel-modules \
"

# Don't include fim for now
# ERROR: fim was skipped: Recipe is blacklisted: BROKEN: doesn't build with B!=S (flex: can't open lex.lex)

FRAMEBUFFER_PACKAGES = "\
    fbida \
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
